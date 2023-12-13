package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PrincipalActivity extends AppCompatActivity {

    Button btncatj,btnretunpaj,btnestadisticaspj,btnconsj,btnnextpj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnnextpj=findViewById(R.id.button);
        btncatj=findViewById(R.id.btncat);
        btnretunpaj=findViewById(R.id.btnretunplast);
        btnestadisticaspj=findViewById(R.id.btnestadisp);
        btnconsj=findViewById(R.id.btncons);

        Intent nextp=new Intent(getApplicationContext(),
                Consejos.class);
        Intent cons=new Intent(getApplicationContext(),
                Consejos.class);

        Intent estadisticasp=new Intent(getApplicationContext(),
                Estadisticas.class);

        Intent retunpa=new Intent(getApplicationContext(),
                MainActivity.class);

        Intent cat=new Intent(getApplicationContext(),
                Categorias.class);
        btnnextpj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(nextp);
            }
        });
        btnconsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cons);
            }
        });
        btnestadisticaspj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(estadisticasp);
            }
        });
        btnretunpaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(retunpa);
            }
        });
        btncatj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(cat);
            }
        });


    }
}