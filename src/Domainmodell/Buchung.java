package Domainmodell;

import java.util.Date;

public class Buchung {

    private int buchungsID;
    private Benutzer benuter;
    private Raum raum;
    Date datum;
    private int zeitraum;


    // Konstrukter
    public Buchung(){

    }

    public Buchung(int buchungsID,Benutzer benuter, Raum raum, int zeitraum){
        this.buchungsID = buchungsID;
        this.benuter = benuter;
        this.raum = raum;
        this.zeitraum = zeitraum;
    }

    public void setBenuter(Benutzer benuter) {
        this.benuter = benuter;
    }

    public void setBuchungsID(int buchungsID) {
        this.buchungsID = buchungsID;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setRaum(Raum raum) {
        this.raum = raum;
    }

    public void setZeitraum(int zeitraum) {
        this.zeitraum = zeitraum;
    }

    public Benutzer getBenuter() {
        return benuter;
    }

    public Date getDatum() {
        return datum;
    }

    public int getBuchungsID() {
        return buchungsID;
    }

    public int getZeitraum() {
        return zeitraum;
    }

    public Raum getRaum() {
        return raum;
    }

}

