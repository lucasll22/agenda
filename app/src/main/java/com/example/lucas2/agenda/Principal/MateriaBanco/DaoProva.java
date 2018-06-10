package com.example.lucas2.agenda.Principal.MateriaBanco;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.Prova;

import java.util.List;

/**
 * Created by lucas on 03/05/2018.
 */

@Dao
public interface DaoProva {

    @Query("SELECT * FROM Prova")
    List<Prova> getAll();

    @Query("SELECT * FROM Prova WHERE id IN (:userIds)")
    List<Prova> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(Prova... users);

    @Delete
    void delete(Prova user);

}
