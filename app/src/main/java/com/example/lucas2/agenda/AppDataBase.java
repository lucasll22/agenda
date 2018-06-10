package com.example.lucas2.agenda;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.lucas2.agenda.Principal.ConverterData;
import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.MateriaBanco.DaoMateria;
import com.example.lucas2.agenda.Principal.MateriaBanco.DaoProva;
import com.example.lucas2.agenda.Principal.MateriaBanco.DaoTrabalho;
import com.example.lucas2.agenda.Principal.Prova;
import com.example.lucas2.agenda.Principal.Trabalho;

/**
 * Created by lucas on 03/05/2018.
 */

@Database(entities = {Materia.class, Prova.class, Trabalho.class}, version = 1)
@TypeConverters({ConverterData.class})
public abstract class AppDataBase extends RoomDatabase {
    public abstract DaoMateria materiaDao();
    public abstract DaoProva provaDao();
    public abstract DaoTrabalho trabalhoDao();

}