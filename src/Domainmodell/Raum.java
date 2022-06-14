package Domainmodell;

public class Raum {

    // Raum Variablen
    int raumID;
    int sitzplaetze;
    boolean  beamer;
    boolean tafelWhiteBoard;
    int anzahlComputer;
    String gebaeude;
    String etage;

    int counter = 0;

    // Konstruktur > erzeugt einen Raum
    public Raum(int sitzplaetze, boolean beamer, boolean tafelWhiteBoard, int anzahlComputer, String gebaeude, String etage){
        this.raumID = fortlaufendeID();
        this.sitzplaetze = sitzplaetze;
        this.beamer = beamer;
        this.tafelWhiteBoard = tafelWhiteBoard;
        this.anzahlComputer = anzahlComputer;
        this.gebaeude = gebaeude;
        this.etage = etage;
    }

    // fortlaufende ID erhöht bei jedem Aufruf die ID um 1 und gibt diese zurück
    // Fehler: Hier das funktioniert noch nicht
    public int fortlaufendeID(){
        counter++;
        return counter;
    }

    public int getRaumID() {
        return raumID;
    }
}
