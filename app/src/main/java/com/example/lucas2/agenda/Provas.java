package com.example.lucas2.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lucas2.agenda.Principal.Prova;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Provas extends AppCompatActivity {

    private List<Prova> provas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        provas = (ArrayList<Prova>) getIntent().getSerializableExtra("provas");


        ArrayAdapter<Prova> adProvas =
                new ArrayAdapter<Prova>(this, android.R.layout.simple_list_item_1, provas);

        ListView listaProvas = findViewById(R.id.listaProvas);
        listaProvas.setAdapter(adProvas);


    }

    public void carregarProvas(){
        try {
            InputStream in = openFileInput("provas");
            ObjectInputStream oin = new ObjectInputStream(in);
            provas = (ArrayList<Prova>) oin.readObject();
            Log.w("leituraProvas", Integer.toString(provas.size()));
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }
    }
}
