package com.example.lucas2.agenda;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.widget.Toast;

/**
 * Created by lucas on 03/05/2018.
 */

public class AppLifeCycle extends Application {

    public static AppDataBase db;

    @Override
    public void onCreate() {
        super.onCreate();
        //Criação do banco
        try
        {
            db = Room.databaseBuilder(getApplicationContext(),
                    AppDataBase.class, "database-name").build();
            //Mensagem na tela
            Toast.makeText(this, "Banco de dados criado", Toast.LENGTH_SHORT).show();

        }
        catch (Exception E)
        {
            Toast.makeText(this, "Erro na criação do banco", Toast.LENGTH_SHORT).show();
        }
    }
}
