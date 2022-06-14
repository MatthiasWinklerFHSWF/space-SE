package Domainmodell;

public class Buchung {
    int buchungsID;
    Benutzer benuter;
    Raum raum;
    //Date datum;
    int zeitraum;


    // Konstrukter
    public Buchung(int buchungsID,Benutzer benuter, Raum raum, int zeitraum){
        this.buchungsID = buchungsID;
        this.benuter = benuter;
        this.raum = raum;
        this.zeitraum = zeitraum;
    }

}
