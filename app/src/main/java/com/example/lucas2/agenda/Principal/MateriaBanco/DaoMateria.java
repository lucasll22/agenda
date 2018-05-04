package com.example.lucas2.agenda.Principal.MateriaBanco;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.example.lucas2.agenda.Principal.Materia;

import java.util.List;

/**
 * Created by lucas on 03/05/2018.
 */

@Dao
public interface DaoMateria {

    @Query("SELECT * FROM Materia")
    List<Materia> getAll();

    @Query("SELECT * FROM Materia WHERE id IN (:userIds)")
    List<Materia> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(Materia... users);

    @Delete
    void delete(Materia user);

}
