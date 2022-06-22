package Domainmodell;

public class Buchung {

    private int buchungsID;
    private Benutzer benuter;
    private Raum raum;
    //Date datum;
    private int zeitraum;


    // Konstrukter
    public Buchung(int buchungsID,Benutzer benuter, Raum raum, int zeitraum){
        this.buchungsID = buchungsID;
        this.benuter = benuter;
        this.raum = raum;
        this.zeitraum = zeitraum;
    }

}
