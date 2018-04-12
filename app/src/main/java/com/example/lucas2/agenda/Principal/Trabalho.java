package com.example.lucas2.agenda.Principal;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lucas on 12/04/2018.
 */

public class Trabalho implements Serializable{
    private String descr;
    private Date dtFinal;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Date dtFinal) {
        this.dtFinal = dtFinal;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return descr + " - " + df.format(dtFinal).toString();
    }
}
