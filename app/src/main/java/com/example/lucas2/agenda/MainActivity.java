/*
Estrutura das classes
    MainActivity tem a tela inicial que pede uns dados
    MainScreen tem a tela inicial do app, com o relatório dos proximos eventos e as opções para as demais telas
    Materias, Provas e Trabalhos contém as tres telas para gerenciar e adicionar novos itens
    NovaMateria, NovaProva, NovoTrabalho tem as telas para gerenciar a adição de dados no app
    Pacote Principal tem as tres classes do modelo do app, já com seus getString para as listas

 O que falta fazer
    Ajustar layouts
    Aquele esquema de criação do banco de dados NoSQL
    Salvar e carregar do banco


 */


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
