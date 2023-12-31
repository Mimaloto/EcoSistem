package com.example.ecosistem;

import static java.lang.Thread.sleep;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SimpleCursorTreeAdapter;
import android.widget.Toast;

import com.example.ecosistem.models.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class RegistrarUsuarioActivity extends AppCompatActivity {

    Button creacj,retunruj;
    TextInputLayout name,email,phone,password1,password2;
    Button register;
    CheckBox cbTerminos;


      @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_registrar_usuario);

          creacj = findViewById(R.id.btncreac);
          retunruj = findViewById(R.id.btnretunru);
          name = findViewById(R.id.name_user);
          email = findViewById(R.id.email_user);
          phone = findViewById(R.id.phone_user);
          password1 = findViewById(R.id.password1_user);
          password2 = findViewById(R.id.password2_user);
          cbTerminos = findViewById(R.id.cbTerminos);


          Intent retunru = new Intent(getApplicationContext(),
                  MainActivity.class);

          Intent login = new Intent(getApplicationContext(),
                  MainActivity.class);

          retunruj.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  startActivity(retunru);
              }
          });

          creacj.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if (validateUser()) {
                      User user = createrUser();
                      saveUser(user);
                      Toast.makeText(getApplicationContext(),
                              "Registro Exitoso", Toast.LENGTH_LONG).show();
                      try {
                          sleep(500);
                          startActivity(login);
                          finish();
                      } catch (InterruptedException e) {
                          throw new RuntimeException(e);
                      }

                  } else {
                      Toast.makeText(getApplicationContext(),
                              "Todos los campos deben estar diligenciados", Toast.LENGTH_LONG).show();
                  }
              }
          });

          cbTerminos.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

              }
          });
      }


    public boolean validateUser(){
        boolean validate= true;

        if(name.getEditText().getText().toString().isEmpty()){
            name.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (email.getEditText().getText().toString().isEmpty()){
            email.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (phone.getEditText().getText().toString().isEmpty()){
            phone.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (password1.getEditText().getText().toString().isEmpty()){
            password1.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (password2.getEditText().getText().toString().isEmpty()){
            password2.setBoxBackgroundColor(Color.RED);
            validate=false;
        }
        if (!password1.getEditText().getText().toString().equals(password2.getEditText().getText().toString())){
            password1.setBoxBackgroundColor(Color.RED);
            password2.setBoxBackgroundColor(Color.RED);
            validate=false;
        }

        return validate;


    }

    public User createrUser(){
        String id,nameUser,emailUser,phoneUser,password;

        nameUser= name.getEditText().getText().toString();
        id=generateID(nameUser);
        emailUser=email.getEditText().getText().toString();
        phoneUser=phone.getEditText().getText().toString();
        password=password1.getEditText().getText().toString();
        User user= new User(id,nameUser,emailUser,phoneUser,password);

        return user;
    }

    public String generateID(String name){
        String id="";
        for (int i=0;i<2;i++){
            int letra= (int) (Math.random()*name.length());
            int number= (int)(Math.random()*1000);
            id+=name.charAt(letra);
            id+=number;
        }
        return id;


    }

    public void saveUser(User user){


        File fileUser= new File(getFilesDir(),"user.txt");



        try {
            //Se define el FileWriter
            FileWriter writer=new FileWriter(fileUser,true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(
                    user.getID()+","+
                            user.getName()+","+
                            user.getEmail()+","+
                            user.getPhone()+","+
                            user.getPassword()
            );
            bufferedWriter.newLine();
            bufferedWriter.close();
        }catch (Exception error){
            error.printStackTrace();
        }

    }



}
