package Domainmodell;

public class Raum {

  // Raum Variablen
  private final int raumID;
  private final int sitzplaetze;
  private final String raumnummer;
  private int counter;

  // Konstruktur > erzeugt einen Raum
  public Raum(int sitzplaetze, String raumnummer) {
    this.raumID = fortlaufendeID();
    this.sitzplaetze = sitzplaetze;
    this.raumnummer = raumnummer;
  }

  // fortlaufende ID erhöht bei jedem Aufruf die ID um 1 und gibt diese zurück
  // Fehler: Das funktioniert noch nicht
  public int fortlaufendeID() {
    counter = 1;
    return counter;
  }

  public int getRaumID() {
    return raumID;
  }

  public String toString() {
    String ausgabe = "";
    ausgabe = "RaumID " + raumID + "\n";
    ausgabe = "Raumnummer " + raumnummer + "\n";
    ausgabe = "Sitzplätze " + sitzplaetze;
    return ausgabe;
  }
}
