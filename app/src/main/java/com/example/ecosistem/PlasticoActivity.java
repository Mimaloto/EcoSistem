package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ecosistem.models.Plastico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class PlasticoActivity extends AppCompatActivity {

    Button btnretunplasj,btnhomeplasj,register;
    EditText quantity,price;
    Spinner month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plastico);

        btnhomeplasj.findViewById(R.id.btnhomeplast);
        btnretunplasj=findViewById(R.id.btnretunplast);
        register=findViewById(R.id.btnRegisterPlastico);
        quantity=findViewById(R.id.etPasticoQuantity);
        price=findViewById(R.id.etPricePlastico);
        month=findViewById(R.id.epinnerMonthPlastico);
        Intent receive = getIntent();
        String idUser = receive.getStringExtra("idUser");


        Intent btnhomepla=new Intent(getApplicationContext(),
                PrincipalActivity.class);
        Intent btnretunplas=new Intent(getApplicationContext(),
                CategoriasActivity.class);


        btnhomeplasj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnhomepla);
                btnretunplasj.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(btnretunplas);
                        register.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (quantity.getText().toString().isEmpty() ||
                                        price.getText().toString().isEmpty() ||
                                        month.getSelectedItem().toString().isEmpty()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Todos los campos deben diligenciarse", Toast.LENGTH_SHORT).show();
                                } else {
                                    int quantityPlastico = Integer.parseInt(quantity.getText().toString());
                                    int pricePlastico = Integer.parseInt(price.getText().toString());
                                    String monthPlastico = month.getSelectedItem().toString();
                                    String serial = idUser + monthPlastico;
                                    Plastico registerPlastico =new Plastico(serial,quantityPlastico,pricePlastico,monthPlastico,idUser);
                                    registerPlastico(registerPlastico);
                                    Toast.makeText(getApplicationContext(), "Registro exitoso",
                                            Toast.LENGTH_SHORT).show();
                                    cleanView();
                                }
                            }
                        });

                    }
                        public void registerPlastico(Plastico recicler){
                            File plasticolFile=new File(getFilesDir(),"plastico.txt");

                            try {
                                FileWriter writer=new FileWriter(plasticolFile, true);
                                BufferedWriter bufferedWriter= new BufferedWriter(writer);
                                bufferedWriter.write(
                                        recicler.getSERIAL()+","+
                                                recicler.getQuantity()+","+
                                                recicler.getPrice()+","+
                                                recicler.getMoth()+","+
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