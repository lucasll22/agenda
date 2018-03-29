package com.example.lucas2.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

    public void buttonMenu(View view) {
        Log.w("tela principal", Integer.toString(view.getId()));
        switch(view.getId())
        {
            case R.id.materias :
                Toast.makeText(this, "materias", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Materias.class);
                startActivity(intent);
                break;
            case R.id.provas :
                Toast.makeText(this, "provas", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Provas.class);
                startActivity(intent2);
                break;
            case R.id.trabalhos :
                Toast.makeText(this, "trabalhos", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Trabalhos.class);
                startActivity(intent3);
                break;
        }

    }
}
