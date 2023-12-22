package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoriasActivity extends AppCompatActivity {
    Button plast, retunc, papel, vidr, home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        plast = findViewById(R.id.btnplastico);
        papel = findViewById(R.id.btnpapel);
        vidr = findViewById(R.id.btnvidrio);
        retunc = findViewById(R.id.btnretuncatego);
        home = findViewById(R.id.btnhomecatego);


        Intent receive = getIntent();
        String idUser = receive.getStringExtra("idUser");
        Intent registerPlas = new Intent(getApplicationContext(),
                PlasticoActivity.class);
        registerPlas.putExtra("idUser", idUser);
        Intent registerPapel = new Intent(getApplicationContext(),
                PapelActivity2.class);
        registerPapel.putExtra("idUser", idUser);
        Intent registerVidr = new Intent(getApplicationContext(),
                VidrioActivity2.class);
        registerVidr.putExtra("idUser", idUser);
        Intent retuncRetornar = new Intent(getApplicationContext(),
                PrincipalActivity.class);
        Intent homeInicio = new Intent(getApplicationContext(),
                CategoriasActivity.class);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(homeInicio);
                retunc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(retuncRetornar);
                    }
                });

            }
        });


        plast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerPlas);
            }
        });
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerPapel);
            }
        });
        vidr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(registerVidr);


            }
        });

    }
}