package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecosistem.models.Vidrio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class VidrioActivity2 extends AppCompatActivity {

    Button btnhomevidj,btnretunvidj,register;
    EditText quantity,price;
    Spinner month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vidrio2);

        btnhomevidj.findViewById(R.id.btnhomeplast);
        btnretunvidj.findViewById(R.id.btnhomeplast);
        quantity.findViewById(R.id.etVidrioQuantity);
        price.findViewById(R.id.etPriceVidrio);
        month.findViewById(R.id.epinnerMonthVidrio);
        register.findViewById(R.id.btnRegisterVidrio);

        Intent btnhomevid=new Intent(getApplicationContext(),
                PrincipalActivity.class);
        Intent btnretunvid=new Intent(getApplicationContext(),
                PapelActivity2.class);
        btnhomevidj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnhomevid);
                btnretunvidj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(btnretunvid);


                        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantity.getText().toString().isEmpty()||
                price.getText().toString().isEmpty()||
                month.getSelectedItem().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "Todos los campos deben estar dilingeciados", Toast.LENGTH_SHORT).show();
                }else{
                    int quantityVidrio= Integer.parseInt(quantity.getText().toString());
                    int priceVidrio= Integer.parseInt(price.getText().toString());
                    String monthVidrio= month.getSelectedItem().toString();
                    String serial= idUser+monthVidrio;
                    Vidrio reciclerVidrio= new Vidrio(serial,quantityVidrio,priceVidrio,monthVidrio,idUser);
                    registerVidrio(reciclerVidrio);
                    Toast.makeText(getApplicationContext(), "Registro Exitoso",
                            Toast.LENGTH_SHORT).show();
                    cleanView();
                }
            }
        });


            }
            public void registerVidrio(Vidrio recicler){

                File vidrioFile= new File(getFilesDir(),"vidrio.txt");

                try {
                    FileWriter writer=new FileWriter(vidrioFile,true);
                    BufferedWriter bufferedWriter=new BufferedWriter(writer);
                    bufferedWriter.write(
                            recicler.getSERIAL()+","+
                                    recicler.getQuantity()+","+
                                    recicler.getPrice()+","+
                                    recicler.getMonth()+","+
                                    recicler.getIdUser()
                    );
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                }catch (Exception e){
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