package com.example.lucas2.agenda;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lucas2.agenda.Principal.Prova;
import com.example.lucas2.agenda.Principal.Trabalho;

import java.util.ArrayList;
import java.util.List;

public class Trabalhos extends AppCompatActivity {

    private List<Trabalho> trabalhos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalhos);

        // ------------Carregar do banco e atualizar a lista
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                trabalhos = AppLifeCycle.db.trabalhoDao().getAll();
                atualizarTrabalhos();
            }

        });

    }

    public void adicionarTrabalho(View view) {
        Intent i = new Intent(this, NovoTrabalho.class);
        startActivity(i);
    }
    public void atualizarTrabalhos()
    {
        ArrayAdapter<Trabalho> adTrabalhos =
                new ArrayAdapter<Trabalho>(this, android.R.layout.simple_list_item_1, trabalhos);

        ListView listaTrabalhos = findViewById(R.id.listaTrabalhos);
        listaTrabalhos.setAdapter(adTrabalhos);
    }

}
