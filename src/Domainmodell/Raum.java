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
    public int fortlaufendeID(){
        raumID++;
        return raumID;
    }

}
