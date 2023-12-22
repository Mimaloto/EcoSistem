package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecosistem.models.Papel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class PapelActivity2 extends AppCompatActivity {

    Button btnpapj,btnhomepapj,btnretunpapj,register;
    EditText quantity,price;
    Spinner month;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_papel2);

        register.findViewById(R.id.btnRegisterPapel);
        btnhomepapj.findViewById(R.id.btnhomeplast);
        btnretunpapj.findViewById(R.id.btnretunplast);
        quantity = findViewById(R.id.etPapelQuantity);
        price = findViewById(R.id.etPricePapel);
        month = findViewById(R.id.epinnerMonthPapel);
        Intent receive = getIntent();
        String idUser = receive.getStringExtra("idUser");

        Intent btnhomepap = new Intent(getApplicationContext(),
                PrincipalActivity.class);
        Intent btnretunpap = new Intent(getApplicationContext(),
                PlasticoActivity.class);
        btnhomepapj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnhomepap);
                btnretunpapj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(btnretunpap);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity.getText().toString().isEmpty() ||
                        price.getText().toString().isEmpty() ||
                        month.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Todos los campos deben diligenciarse", Toast.LENGTH_SHORT).show();
                } else {
                    int quantityPapel = Integer.parseInt(quantity.getText().toString());
                    int pricePapel = Integer.parseInt(price.getText().toString());
                    String monthPapel = month.getSelectedItem().toString();
                    String serial = idUser + monthPapel;
                    Papel registerPapel = new Papel(serial,quantityPapel,pricePapel,monthPapel, idUser);
                    registerPapel(registerPapel);
                    Toast.makeText(getApplicationContext(), "Registro exitoso",
                            Toast.LENGTH_SHORT).show();
                    cleanView();
                }
            }
        });

    }
    public void registerPapel(Papel recicler){
        File papelFile=new File(getFilesDir(),"papel.txt");

        try {
            FileWriter writer=new FileWriter(papelFile, true);
            BufferedWriter bufferedWriter= new BufferedWriter(writer);
            bufferedWriter.write(
                    recicler.getSERIAL()+","+
                            recicler.getQuantity()+","+
                            recicler.getPrice()+","+
                            recicler.getMonth()+","+
                            recicler.getIdUser()
            );
        bufferedWriter.newLine();
        bufferedWriter.close();
        }catch (Exception e) {
            e.printStackTrace();

        }
        }
        public void cleanView(){
        quantity.setText("");
        price.setText("");
        month.setSelection(0);

            }
        });
            }
        });
    }
}