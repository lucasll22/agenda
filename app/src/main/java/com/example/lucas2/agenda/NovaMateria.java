package com.example.lucas2.agenda;

import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.lucas2.agenda.Principal.Materia;

public class NovaMateria extends AppCompatActivity {

    private int indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_materia);

        //Controle do drop down

        Spinner dropdown = findViewById(R.id.matSpinner);

        String[] itensDropDown = new String[]{"Dom", "seg", "ter", "qua", "qui", "sex", "sab"};

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, itensDropDown);

        dropdown.setAdapter(ad);
    }

    public void adicionarMateria(View view) {
        final Materia temp = new Materia();

        EditText descr = findViewById(R.id.matDescr);
        Spinner dia = findViewById(R.id.matSpinner);
        temp.setDescr(descr.getText().toString());
        temp.setDia(dia.getSelectedItemPosition());

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                AppLifeCycle.db.materiaDao().insertAll(temp);
            }
        });


    }
}
