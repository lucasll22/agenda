package com.example.lucas2.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prosseguir(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        TextView nome = findViewById(R.id.nome);
        TextView inst = findViewById(R.id.instituição);

        intent.putExtra("nome", nome.getText().toString());
        intent.putExtra("inst", inst.getText().toString());
        startActivity(intent);


    }
}
