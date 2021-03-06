package com.example.lucas2.agenda;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.Prova;

import java.util.ArrayList;
import java.util.List;

public class Materias extends AppCompatActivity {

    private static List<Materia> materias = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias);

        //materias = (ArrayList<Materia>) getIntent().getSerializableExtra("materias");
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                materias = AppLifeCycle.db.materiaDao().getAll();
                atualizarMaterias();
            }

        });


    }

    public void adicionarMateria(View view) {
        Intent i = new Intent(this, NovaMateria.class);
        startActivity(i);
    }

    public void atualizarMaterias()
    {
        ArrayAdapter<Materia> adMateria =
                new ArrayAdapter<Materia>(this, android.R.layout.simple_list_item_1, materias);

        ListView listaMaterias = findViewById(R.id.listaMaterias);
        listaMaterias.setAdapter(adMateria);

    }
}
