package com.example.lucas2.agenda;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.MateriaBanco.DaoMateria;

/**
 * Created by lucas on 03/05/2018.
 */

@Database(entities = {Materia.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {


    public abstract DaoMateria materiaDao();
}