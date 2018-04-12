package com.example.lucas2.agenda;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.Prova;
import com.example.lucas2.agenda.Principal.Trabalho;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainScreen extends AppCompatActivity {

    private List<Prova> provas = new ArrayList<Prova>();
    private List<Materia> materias = new ArrayList<Materia>();
    private List<Trabalho> trabalhos = new ArrayList<Trabalho>();

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


        Prova p = new Prova();
        p.setDescr("Uma prova!");
        p.setData(new Date());
        p.setHorarioInicio(new Time(10, 12, 00));
        provas.add(p);

        Materia m = new Materia();
        m.setDescr("Mat");
        m.setDia(1);
        materias.add(m);

        Trabalho t = new Trabalho();
        t.setDescr("Um trab");
        t.setDtFinal(new Date());
        trabalhos.add(t);

        //salvarTudo();

    }

    public void buttonMenu(View view) {
        Log.w("tela principal", Integer.toString(view.getId()));
        switch(view.getId())
        {
            case R.id.materias :
                Toast.makeText(this, "materias", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Materias.class);

                intent.putExtra("materias", (Serializable) materias);


                startActivity(intent);
                break;
            case R.id.provas :

                Toast.makeText(this, "provas", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Provas.class);

                intent2.putExtra("provas", (Serializable) provas);

                startActivity(intent2);
                break;
            case R.id.trabalhos :
                Toast.makeText(this, "trabalhos", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, Trabalhos.class);

                intent3.putExtra("trabalhos", (Serializable) trabalhos);

                startActivity(intent3);
                break;
        }

    }

    public void salvarTudo()
    {

        try {
            OutputStream out = openFileOutput("provas", Context.MODE_PRIVATE);
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(provas);
        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

    }
}
