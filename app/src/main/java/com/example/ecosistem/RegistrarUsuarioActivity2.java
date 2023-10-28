package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrarUsuarioActivity2 extends AppCompatActivity {

    Button btncreacj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario2);

        btncreacj.findViewById(R.id.btncreac);

        Intent btncreac=new Intent(getApplicationContext(),
                MainActivity.class);
        btncreacj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btncreac);

            }
        });



    }
}
