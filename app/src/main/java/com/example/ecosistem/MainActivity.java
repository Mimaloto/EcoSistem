package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.ecosistem.models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btninsj;
    Button btncrearctj;

    EditText passwordacj,emailacj;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsj = findViewById(R.id.btnins);
        btncrearctj = findViewById(R.id.btncrearct);
        emailacj = findViewById(R.id.ediTextemailac);
        passwordacj = findViewById(R.id.ediTextpasswordac);

        Intent categorias=new Intent(getApplicationContext(),
                Categorias.class);


        Intent btncrearct = new Intent(getApplicationContext(),
                RegistrarUsuarioActivity.class);

        File fileUser = new File(getFilesDir(), "user.txt");

          ArrayList<User> users= listUser(fileUser);


        btncrearctj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(btncrearct);
            }
        });

         btninsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean state = false;
                if (emailacj.getText().toString().isEmpty() ||
                        passwordacj.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Ambos campos deben estar diligenciados", Toast.LENGTH_LONG).show();
                } else {
                    String userLogin = emailacj.getText().toString();
                    for (User i : users) {
                        if (i.getName().equals(userLogin) ||
                                i.getEmail().equals(userLogin) ||
                                i.getPhone().equals(userLogin)) {
                            state = true;
                            if (i.getPassword().equals(passwordacj.getText().toString())) {

                                categorias.putExtra("idUser", i.getId());
                                startActivity(categorias);
                                break;
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "La contraseña es incorrecta", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (!state) {
                        Toast.makeText(getApplicationContext(),
                                "El usuario no esta registrado", Toast.LENGTH_LONG).show();
                        startActivity(btncrearct);

                    }
                }

            }
        });

    }

    public ArrayList<User> listUser(File data){
        ArrayList<User> list= new ArrayList<>();

        try {
            FileReader reader= new FileReader(data);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String user;

            while ((user=bufferedReader.readLine())!=null){
                String[] userData= user.split(",");
                String id= userData[0];
                String name= userData[1];
                String email=userData[2];
                String phone= userData[3];
                String password= userData[4];

                User userObject= new User(id,name,email,phone,password);
                list.add(userObject);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }


}