package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categorias extends AppCompatActivity {

    Button btnplastj,btnretuncj;
    Button btnpapelj;
    Button btnvidrj,btnhomecatj;

    public static void putExtra(String idUser, String id) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        btnplastj=findViewById(R.id.btnplast);
        btnpapelj=findViewById(R.id.btnpapel);
        btnvidrj=findViewById(R.id.btnvidr);
        btnretuncj=findViewById(R.id.btnretunplast);
        btnhomecatj=findViewById(R.id.btnhomeplast);



        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        Intent plastico_View= new Intent(getApplicationContext(),
                PlasticoActivity.class);
        plastico_View.putExtra("idUser",idUser);

        Intent vidrio_View= new Intent(getApplicationContext(),
                VidrioActivity2.class);
        vidrio_View.putExtra("idUser",idUser);

        Intent papel_View= new Intent(getApplicationContext(),
                PapelActivity2.class);
        papel_View.putExtra("idUser",idUser);

        Intent btnhomecat=new Intent(getApplicationContext(),
                PrincipalActivity.class);

        Intent btnplast=new Intent(getApplicationContext(),
                PlasticoActivity.class);
        Intent btnpapel=new Intent(getApplicationContext(),
                PapelActivity2.class);
        Intent btnvidr=new Intent(getApplicationContext(),
                VidrioActivity2.class);
        Intent btnretunc=new Intent(getApplicationContext(),
                PrincipalActivity.class);
        btnhomecatj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnhomecat);
            }
        });

        btnretuncj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnretunc);
            }
        });

        btnplastj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnplast);

            }
        });
        btnpapelj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnpapel);
            }
        });
        btnvidrj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnvidr);
            }
        });


    }
}