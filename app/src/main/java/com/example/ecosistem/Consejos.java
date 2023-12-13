package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consejos extends AppCompatActivity {

    Button btnatrascj,btnhomecj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);
        btnatrascj=findViewById(R.id.btnretunplast);
        btnhomecj=findViewById(R.id.btnhomeplast);

        Intent btnatrasc=new Intent(getApplicationContext(),
                Estadisticas.class);
        Intent btnhomec=new Intent(getApplicationContext(),
                PrincipalActivity.class);
        btnatrascj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnatrasc);

        btnhomecj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnhomec);
            }
        });
            }
        });
    }
}