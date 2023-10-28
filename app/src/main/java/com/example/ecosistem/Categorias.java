package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categorias extends AppCompatActivity {

    Button btnplastj;
    Button btnpapelj;
    Button btnvidrj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        btnplastj.findViewById(R.id.btnplast);
        btnpapelj.findViewById(R.id.btnpapel);
        btnvidrj.findViewById(R.id.btnvidr);

        Intent btnplast=new Intent(getApplicationContext(),
                Plastico.class);
        Intent btnpapel=new Intent(getApplicationContext(),
                PapelActivity2.class);
        Intent btnvidr=new Intent(getApplicationContext(),
                VidrioActivity2.class);

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