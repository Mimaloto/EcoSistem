package com.example.ecosistem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ecosistem.models.Vidrio;
import com.example.ecosistem.models.Papel;
import com.example.ecosistem.models.Plastico;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MoreStatisticsActivity extends AppCompatActivity {


    TableLayout plastico, papel,vidrio,homem,retunm;

    TextView username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_statistics);
        plastico= findViewById(R.id.TablePlastico);
        papel= findViewById(R.id.TablePapel);
        vidrio=findViewById(R.id.TableVidrio);
        username=findViewById(R.id.textViewUsername);
        homem=findViewById(R.id.button40);
        retunm=findViewById(R.id.button41);

        Intent homemore=new Intent(getApplicationContext(),
                Estadisticas.class);
        Intent retunmore=new Intent(getApplicationContext(),
                CategoriasActivity.class);
        homem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(homemore);
            }
        });
        retunm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(retunmore);
            }
        });

        Intent receive= getIntent();
        String userID= receive.getStringExtra("idUser");

        File plasticoFile= new File(getFilesDir(),"plastico.txt");
        File papelFile= new File(getFilesDir(),"papel.txt");
        File vidrioFile= new File(getFilesDir(),"vidrio.txt");
        File userFile= new File(getFilesDir(),"user.txt");

        ArrayList<Plastico> listPlastico= registerPlastico(plasticoFile,userID);
        inflatePlasticoTable(listPlastico);

        ArrayList<Papel> listPapel= registerPapel(papelFile,userID);
        inflatePapelTable(listPapel);

        ArrayList<Vidrio> listVidrio= registerVidrio(vidrioFile,userID);
        inflateVidrioTable(listVidrio);

        String name_user= nameUser(userFile,userID);
        username.setText(name_user);

    }


    public void inflatePlasticoTable(ArrayList<Plastico>list){

        int total=0;
        String averageValue="";
        System.out.println("Antes");
        for (Plastico i: list){
            TableRow row=new TableRow(this);
            TextView quantity= new TextView(this);
            quantity.setWidth(97);
            quantity.setTextSize(14);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView price= new TextView(this);
            price.setTextSize(14);
            price.setWidth(96);
            price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView month= new TextView(this);
            month.setWidth(105);
            month.setTextSize(14);
            month.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView average= new TextView(this);
            average.setWidth(90);
            average.setTextSize(14);
            average.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            month.setText(i.getMoth());
            total= totalPlastico(list);
            averageValue=average(total,i.getQuantity());
            average.setText(averageValue+"%");

            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(average);

            plastico.addView(row);
        }
    }

    public void inflatePapelTable(ArrayList<Papel>list){
        int total=0;
        String averageValue="";
        System.out.println("Antes");
        for (Papel i: list){
            TableRow row=new TableRow(this);
            TextView quantity= new TextView(this);
            quantity.setWidth(97);
            quantity.setTextSize(14);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView price= new TextView(this);
            price.setTextSize(14);
            price.setWidth(96);
            price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView month= new TextView(this);
            month.setWidth(105);
            month.setTextSize(14);
            month.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView average= new TextView(this);
            average.setWidth(90);
            average.setTextSize(14);
            average.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            month.setText(i.getMonth());
            total=  totalPapel(list);
            averageValue=average(total,i.getQuantity());
            average.setText(averageValue+"%");

            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(average);

            papel.addView(row);
        }
    }


    public void inflateVidrioTable(ArrayList<Vidrio>list){

        int total=0;
        String averageValue="";
        System.out.println("Antes");
        for (Vidrio i: list){
            TableRow row=new TableRow(this);
            TextView quantity= new TextView(this);
            quantity.setWidth(97);
            quantity.setTextSize(14);
            quantity.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView price= new TextView(this);
            price.setTextSize(14);
            price.setWidth(96);
            price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView month= new TextView(this);
            month.setWidth(105);
            month.setTextSize(14);
            month.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            TextView average= new TextView(this);
            average.setWidth(90);
            average.setTextSize(14);
            average.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            quantity.setText(i.getQuantity()+"");
            price.setText(i.getPrice()+"");
            month.setText(i.getMonth());
            total= totalVidrio(list);
            averageValue=average(total,i.getQuantity());
            average.setText(averageValue+"%");

            row.addView(month);
            row.addView(quantity);
            row.addView(price);
            row.addView(average);

            vidrio.addView(row);
        }
    }

    public ArrayList<Plastico> registerPlastico(File plastico, String id){
        ArrayList<Plastico> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(plastico);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                if (id.equals(data[4])){
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String serial= data[0];
                    Plastico obj= new Plastico(serial,quantity,price,month,id);
                    list.add(obj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Vidrio> registerVidrio(File vidrio, String id){
        ArrayList<Vidrio> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(vidrio);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                if (id.equals(data[4])){
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String serial= data[0];
                    Vidrio obj= new Vidrio(serial,quantity,price,month,id);
                    list.add(obj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }


    public ArrayList<Papel> registerPapel(File papel, String id){
        ArrayList<Papel> list= new ArrayList<>();
        try {
            FileReader reader= new FileReader(papel);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String line;
            System.out.println(reader.toString());
            while ((line=bufferedReader.readLine())!=null){
                String [] data= line.split(",");
                if (id.equals(data[4])){
                    System.out.println(line);
                    int quantity= Integer.parseInt(data[1]);
                    int price= Integer.parseInt(data[2]);
                    String month= data[3];
                    String serial= data[0];
                    Papel obj = new Papel(serial,quantity,price,month,id);
                    list.add(obj);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list.size());
        return list;
    }

    public int totalPlastico (ArrayList<Plastico> list){
        int total=0;
        for (Plastico i: list){
            total+=i.getQuantity();
        }
        return total;
    }

    public int totalPapel(ArrayList<Papel> list){
        int total=0;
        for (Papel i: list){
            total+=i.getQuantity();
        }
        return total;
    }

    public int totalVidrio(ArrayList<Vidrio> list){
        int total=0;
        for (Vidrio i: list){
            total+=i.getQuantity();
        }
        return total;
    }

    public String average(int total, int quantity){
        if (total==0){
            return "Error";
        }else{
            double total_d= total;
            double quantity_d=quantity;
            double avg= (quantity_d/total_d)*100; //2.3698
            DecimalFormat df= new DecimalFormat("#.##");// 2.36
            // df.setRoundingMode(RoundingMode.FLOOR); 2.37
            return df.format(avg);
        }
    }

    public String nameUser(File data, String idUser){
        String name="";
        try {
            //Para leer datos de un archivo plano se usa el FileReader
            FileReader reader= new FileReader(data);
            BufferedReader bufferedReader= new BufferedReader(reader);
            String user;
            while ((user=bufferedReader.readLine())!=null){
                String[] userData= user.split(",");
                if (idUser.equals(userData[0])){
                    name= userData[1];
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return name;
    }
}