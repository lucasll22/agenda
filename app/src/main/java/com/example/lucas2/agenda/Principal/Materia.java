package com.example.lucas2.agenda.Principal;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by lucas on 12/04/2018.
 */

@Entity
public class Materia implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String descr;

    private int dia;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDia() {
        return dia;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getDiaString(){
        String diaTemp;
        switch (dia){
            case 0:
                diaTemp = "domingo";
                break;
            case 1:
                diaTemp = "segunda";
                break;
            case 2:
                diaTemp = "terça";
                break;
            case 3:
                diaTemp = "quarta";
                break;
            case 4:
                diaTemp = "quinta";
                break;
            case 5:
                diaTemp = "sexta";
                break;
            case 6:
                diaTemp = "sábado";
                break;
            default:
                diaTemp = "";
        }
        return diaTemp;
    }

    @Override
    public String toString() {
        return descr + " - " + getDiaString();
    }
}
