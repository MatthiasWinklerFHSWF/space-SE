package Domainmodell;

public class Raum {

  // Raum Variablen
  private int raumID;
  private int sitzplaetze;
  private String raumnummer;


  public Raum(){

  }

  // Konstruktur > erzeugt einen Raum
  public Raum(int sitzplaetze, String raumnummer) {
    this.raumID = (int) (20*Math.random());
    this.sitzplaetze = sitzplaetze;
    this.raumnummer = raumnummer;
  }

  public int getRaumID() {
    return raumID;
  }

  public int getSitzplaetze() {
    return sitzplaetze;
  }

  public String getRaumnummer() {
    return raumnummer;
  }

  public void setRaumID(int raumID) {
    this.raumID = raumID;
  }

  public void setRaumnummer(String raumnummer) {
    this.raumnummer = raumnummer;
  }

  public void setSitzplaetze(int sitzplaetze) {
    this.sitzplaetze = sitzplaetze;
  }

  public String toString() {
    String ausgabe = "";
    ausgabe = "RaumID " + raumID + " Raumnummer " + raumnummer + " Sitzplätze " + sitzplaetze;
    return ausgabe;
  }
}
