package com.example.lucas2.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NovaMateria extends AppCompatActivity {

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
}
