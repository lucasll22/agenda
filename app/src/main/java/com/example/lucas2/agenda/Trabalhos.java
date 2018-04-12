package com.example.lucas2.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        trabalhos = (ArrayList<Trabalho>) getIntent().getSerializableExtra("trabalhos");

        ArrayAdapter<Trabalho> adTrabalhos =
                new ArrayAdapter<Trabalho>(this, android.R.layout.simple_list_item_1, trabalhos);

        ListView listaTrabalhos = findViewById(R.id.listaTrabalhos);
        listaTrabalhos.setAdapter(adTrabalhos);

    }
}
