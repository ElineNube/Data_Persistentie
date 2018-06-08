package Inleveropdrachten.Les2;

import java.sql.Date;

public class OVChipkaart {
	private int kaartnummer;
    private Date geldigTot;
    private int klasse;
    private double saldo;
    private int reizigerID;
    
    public OVChipkaart(int kaartnummer, Date geldigTot,  int klasse, double saldo, int reizigerID) {
    	this.kaartnummer = kaartnummer;
    	this.geldigTot = geldigTot;
    	this.klasse = klasse;
    	this.saldo = saldo;
    	this.reizigerID = reizigerID;
    }

    public int getKaartnummer() {
        return kaartnummer;
    }

    public void setKaartnummer(int kaartnummer) {
        this.kaartnummer = kaartnummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getReizigerID() {
        return reizigerID;
    }

    public void setReizigerID(int reizigerID) {
        this.reizigerID = reizigerID;
    }
    
    public String toString() {
    	String result = "* OV Chipkaart met kaartnummer " + kaartnummer + " is geldig tot " + geldigTot + " rijdt met klasse " + klasse + " heeft een saldo van " + saldo + " en is van"
    			+ " de reiziger met id: " + reizigerID + "\n";
    	return result;
    }
}
