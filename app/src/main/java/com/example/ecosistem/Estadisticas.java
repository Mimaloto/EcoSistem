package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.StringSearch;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ecosistem.models.Papel;
import com.example.ecosistem.models.Plastico;
import com.example.ecosistem.models.Vidrio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Estadisticas extends AppCompatActivity {

    Button bntretunestadj,btnhomeej,btnconsej;
    TextView totalVidrio,totalPapel,totalPlastico,total_Pay,
            max_vidrio_month,max_papel_month,max_plastico_month,
            max_vidrio_quantity,max_papel_quantity,max_plastico_quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);

        btnconsej=findViewById(R.id.button);
        btnhomeej=findViewById(R.id.btnhomeplast);
        bntretunestadj=findViewById(R.id.btnretunplast);
        totalVidrio=findViewById(R.id.textViewTotalVidrio);
        totalPapel=findViewById(R.id.textViewTotalPapel);
        totalPlastico=findViewById(R.id.textViewTotalPlastico);
        total_Pay=findViewById(R.id.textViewTotalPay);
        max_vidrio_month=findViewById(R.id.textViewMonthMaxVidrio);
        max_papel_month=findViewById(R.id.textViewMonthMaxPapel);
        max_plastico_month=findViewById(R.id.textViewMonthMaxPlastico);
        max_vidrio_quantity=findViewById(R.id.textViewMaxVidrioQuantity);
        max_papel_quantity=findViewById(R.id.textViewMaxPapelQuantity);
        max_plastico_quantity=findViewById(R.id.textViewMaxPlasticoQuantity);
        Intent btnconse=new Intent(getApplicationContext(),
                Consejos.class);
        Intent btnhomee=new Intent(getApplicationContext(),
                PrincipalActivity.class);
        Intent btnretunestad=new Intent(getApplicationContext(),
                Categorias.class);
        btnconsej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnconse);
            }
        });
        btnhomeej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(btnhomee);
            }
        });
        bntretunestadj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(btnretunestad);
        Intent receive= getIntent();
        String idUser= receive.getStringExtra("idUser");

        File vidrio=new File(getFilesDir(),"vidrio.txt");
        File papel=new File(getFilesDir(),"papel.txt");
        File plastico=new File(getFilesDir(),"plasticotxt");

        ArrayList<Vidrio> list_vidrio= list_Vidrio(vidrio,idUser);
        ArrayList<Papel> list_papel= list_Papel(papel,idUser);
        ArrayList<Plastico> list_plastico= list_Plastico(plastico,idUser);

        total_recicler_vidrio(list_vidrio);
        total_recicler_papel(list_papel);
        total_recicler_plastico(list_plastico);

        int total=totalPayVidrio(list_vidrio)+totalPayPapel(list_papel)+totalPayPastico(list_plastico);
        total_Pay.setText("$ "+total);


            }
            public int totalPayVidrio(ArrayList<Vidrio>list){
                int pay=0;
                for (Vidrio i:list){
                    pay+=i.getPrice();
                }
                return pay;
            }

        public int totalPayPapel(ArrayList<Papel>list){
            int pay=0;
            for (Papel i:list){
                pay+=i.getPrice();
            }
            return pay;
        }
            public int totalPayPastico(ArrayList<Plastico>list){
                int pay=0;
                for (Plastico i:list){
                    pay+=i.getPrice();
                }
                return pay;
            }
            public void total_recicler_vidrio(ArrayList<Vidrio>list){
                int total=0;
                String month="";
                int max=0;
                for (Vidrio i:list){
                    total+=i.getQuantity();
                    if (max<i.getQuantity()){
                        max=i.getQuantity();
                        month=i.getMonth();
                    }
                }
                totalVidrio.setText(total+" L");
                max_vidrio_quantity.setText(max+" l");
                max_vidrio_month.setText(month);

            }
            public void total_recicler_papel(ArrayList<Papel>list) {
                int total = 0;
                String month = "";
                int max = 0;
                for (Papel i : list) {
                    total += i.getQuantity();
                    if (max < i.getQuantity()) {
                        max = i.getQuantity();
                        month = i.getMonth();
                    }
                }
                totalPapel.setText(total + " L");
                max_papel_quantity.setText(max + " l");
                max_papel_month.setText(month);
            }
            public void total_recicler_plastico(ArrayList<Plastico>list) {
                int total = 0;
                String month = "";
                int max = 0;
                for (Plastico i : list) {
                    total += i.getQuantity();
                    if (max < i.getQuantity()) {
                        max = i.getQuantity();
                        month = i.getMonth();
                    }
                }
                totalPlastico.setText(total + " L");
                max_plastico_quantity.setText(max + " l");
                max_plastico_month.setText(month);
            }
            public ArrayList<Vidrio>list_Vidrio(File vidrio,String user) {
                ArrayList<Vidrio> list = new ArrayList<>();
                try {
                    FileReader reader = new FileReader(vidrio);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String cadena;
                    while ((cadena = bufferedReader.readLine()) != null) {
                        String[] data = cadena.split(",");
                        if (data[4].equals(user)) {
                            String serial = data[0];
                            int quantity = Integer.parseInt(data[1]);
                            int price = Integer.parseInt(data[2]);
                            String month = data[3];
                            String idUser = data[4];

                            Vidrio obj = new Vidrio(serial, quantity, price, month, idUser);
                            list.add(obj);


                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return list;
            }
            public ArrayList<Papel>list_Papel(File papel,String user) {
                ArrayList<Papel> list = new ArrayList<>();
                try {
                    FileReader reader = new FileReader(papel);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String cadena;
                    while ((cadena = bufferedReader.readLine()) != null) {
                        String[] data = cadena.split(",");
                        if (data[4].equals(user)) {
                            String serial = data[0];
                            int quantity = Integer.parseInt(data[1]);
                            int price = Integer.parseInt(data[2]);
                            String month = data[3];
                            String idUser = data[4];

                            Papel obj = new Papel(serial, quantity, price, month, idUser);
                            list.add(obj);


                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return list;
            }
            public ArrayList<Plastico>list_Plastico(File plastico,String user) {
                ArrayList<Plastico> list = new ArrayList<>();
                try {
                    FileReader reader = new FileReader(plastico);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String cadena;
                    while ((cadena = bufferedReader.readLine()) != null) {
                        String[] data = cadena.split(",");
                        if (data[4].equals(user)) {
                            String serial = data[0];
                            int quantity = Integer.parseInt(data[1]);
                            int price = Integer.parseInt(data[2]);
                            String month = data[3];
                            String idUser = data[4];

                            Plastico obj = new Plastico(serial, quantity, price, month, idUser);
                            list.add(obj);


                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return list;
            }

        });

    }
}