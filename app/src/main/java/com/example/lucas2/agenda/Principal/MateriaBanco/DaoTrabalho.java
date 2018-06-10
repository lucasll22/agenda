package com.example.lucas2.agenda.Principal.MateriaBanco;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.lucas2.agenda.Principal.Materia;
import com.example.lucas2.agenda.Principal.Trabalho;

import java.util.List;

/**
 * Created by lucas on 03/05/2018.
 */

@Dao
public interface DaoTrabalho {

    @Query("SELECT * FROM Trabalho")
    List<Trabalho> getAll();

    @Query("SELECT * FROM Trabalho WHERE id IN (:userIds)")
    List<Trabalho> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(Trabalho... users);

    @Delete
    void delete(Trabalho user);

}
