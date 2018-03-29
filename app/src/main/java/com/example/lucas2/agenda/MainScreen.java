package com.example.lucas2.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Intent intent = getIntent();
        String nome = intent.getExtras().getString("nome");
        String inst = intent.getExtras().getString("inst");

        TextView tela = findViewById(R.id.tela);

        tela.setText("Bem vindo " + nome);
        tela.append("\n" + inst);

    }
}
