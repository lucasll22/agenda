package com.example.lucas2.agenda.Principal;

import java.io.Serializable;

/**
 * Created by lucas on 12/04/2018.
 */

public class Materia implements Serializable{
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
