package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btninsj;
    TextView texvolvdcj;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btninsj=findViewById(R.id.btnins);
        texvolvdcj=findViewById(R.id.texvolvdc);

        Intent btnins= new Intent(getApplicationContext(),
                PrincipalActivity.class);
        Intent texvolvdc = new Intent(getApplicationContext(),
                RegistrarUsuarioActivity2.class);

        btninsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnins);

            }
        });

        texvolvdcj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(texvolvdc);
            }
        });


    }
}