package Domainmodell;

public class Raum {

    // Raum Variablen
    private int raumID;
    private int sitzplaetze;
    private String raunnummer;


    int counter = 0;

    // Konstruktur > erzeugt einen Raum
    public Raum(int sitzplaetze, String raunnummer){
        this.raumID = fortlaufendeID();
        this.sitzplaetze = sitzplaetze;
        this.raunnummer = raunnummer;

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
