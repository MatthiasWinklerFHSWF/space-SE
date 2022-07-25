package Domainmodell;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Buchung {

    private int buchungsID;
    private Benutzer benutzer;
    private Raum raum;
    // Datum -- der Tag an dem die Buchung ist
    Date datum;
    // Tag in 10 Blöcken aufgeteilt a 1 Stunde (7-17 Uhr)
    private int zeitraum;


    // Konstruktor für XML -> leer
    public Buchung(){

    }

    //Konstruktor mit Anweisungen
    public Buchung(Benutzer benutzer, Raum raum, int zeitraum, Date datum){
        // ToDo BuchungsID über XML erstellen
        this.buchungsID = (int) Math.random();
        this.benutzer = benutzer;
        this.raum = raum;
        this.zeitraum = zeitraum;
        this.datum = datum;
    }

    public static Date createDate(int year, int month, int date){
        Calendar myCalendar = new GregorianCalendar(year, (month-1), date);
        Date myDate = myCalendar.getTime();
        return myDate;
    }

    public String printZeitraum(int zeitraum){
        String ausgabe = "";
        ausgabe = "Zeitraum " + zeitraum + " = " + (zeitraum + 6)+ ":00" + " Uhr bis " + (zeitraum + 7) +":00" + " Uhr.";

        return ausgabe;
    }

    public String toString(){
        String ausgabe = "";
        ausgabe += "BuchungsID: " + buchungsID + "\n" +
                benutzer +
                raum + "\n" +
                printZeitraum(getZeitraum()) + "\n" +
                "Datum: " + datum.getDate() + "." + (datum.getMonth()+1);
        return ausgabe;
    }


    public void setBenutzer(Benutzer benutzer) {
        this.benutzer = benutzer;
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

    public Benutzer getBenutzer() {
        return benutzer;
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

