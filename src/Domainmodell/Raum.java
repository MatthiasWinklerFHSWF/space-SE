package Domainmodell;

public class Raum {

    // Raum Variablen
    private int raumID;
    private int sitzplaetze;
    private boolean  beamer;
    private boolean tafelWhiteBoard;
    private int anzahlComputer;
    private String gebaeude;
    private String etage;

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
    // Fehler: Das funktioniert noch nicht
    public int fortlaufendeID(){
        counter++;
        return counter;
    }

    public int getRaumID() {
        return raumID;
    }
}
