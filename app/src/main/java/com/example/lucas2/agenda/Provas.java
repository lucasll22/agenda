package com.example.lucas2.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        // --------------------- carregar trabalhos e atualizar lista

        ArrayAdapter<Prova> adProvas =
                new ArrayAdapter<Prova>(this, android.R.layout.simple_list_item_1, provas);

        ListView listaProvas = findViewById(R.id.listaProvas);
        listaProvas.setAdapter(adProvas);


    }

    public void adicionarProva(View view) {
        Intent i = new Intent(this, NovaProva.class);
        startActivity(i);
    }

    public void adicionarTrabalho(View view) {
        Intent i = new Intent(this, NovoTrabalho.class);
        startActivity(i);
    }


}
