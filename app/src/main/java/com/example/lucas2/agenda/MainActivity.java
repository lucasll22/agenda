/*
Estrutura das classes
    MainActivity tem a tela inicial que pede uns dados
    MainScreen tem a tela inicial do app, com o relatório dos proximos eventos e as opções para as demais telas
    Materias, Provas e Trabalhos contém as tres telas para gerenciar e adicionar novos itens
    NovaMateria, NovaProva, NovoTrabalho tem as telas para gerenciar a adição de dados no app
    AddLifeCycle, NÃO ENTRE, NÃO ENCOSTE, NÃO TOQUE
    Pacote Principal tem as tres classes do modelo do app, já com seus getString para as listas



 O que falta fazer
    Ajustar layouts
    Aquele esquema de criação do banco de dados NoSQL
    Salvar e carregar do banco

Banco de dados já adaptado ao projeto
Banco de dados já funcionando para as matérias, salvando e carregando

Como adaptar para as outras duas tabelas
    1- Adaptar suas classes modelo (Prova e Trabalho) em /principal usando @entity, criando uma ID e usando como Primary Key
    2- Criar sua classe DAO em /Principal/ProvaBanco e /Principal/TrabalhoBanco, criar os pacotes
    3- em AppDatabase, linha 13 adicionar as classes Prova e Trabalho
    Creio eu que é isso

    Exemplo de adicionar algo no banco encontrado em NovaMateria
    Exemplo de carregar tudo do banco encontrado em Materias
    Exemplo de atualizar a lista do que foi carregado do banco na tela, em Materias
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
