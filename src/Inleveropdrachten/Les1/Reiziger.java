package Inleveropdrachten.Les1;

import java.sql.Date;
import java.util.ArrayList;

public class Reiziger {
    private String naam;
    private Date geboortedatum;

    public Reiziger(String naam, Date geboortedatum) {
        this.naam = naam;
        this.geboortedatum = geboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getGBdatum() {
        return geboortedatum;
    }

    public void setGBdatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString() {
        String res = naam + "-" + geboortedatum;
        return res;
    }



}
