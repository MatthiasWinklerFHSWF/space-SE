package Logic;

import Domainmodell.Buchung;
import Domainmodell.Raum;

public class Raummanager implements IRaummanager {

  Raum[] raum = new Raum[999];

  @Override
  public void addRaum(Raum raum) {

    // ToDo: Exists in Methode ExistsRoom umwandeln
    boolean exists = false;

    // überprüfen ob der Raum bereits exisitiert
    // For-Schleife solange durchlaufen wie Räume im Array sind
    for (int i = 0; i < this.raum.length; i++){
      //Überprüft ob eine Raumnummer im Array vorhanden ist
      if ( (this.raum[i] != null) && (this.raum[i].getRaumnummer().equals(raum.getRaumnummer()))){
          System.out.println("Raum bereits vorhanden - hinzufügen fehlgeschlagen");
          exists = true;
          break;
      }
    }

    // den Raum an die nächste freie Stelle im Array einfügen
    //Array durchlaufen
    for (int i = 0; i < this.raum.length; i++) {
      //Freie Stelle im Array finden
      if (this.raum[i] == null && !exists) {
        //Raum an freie Stelle einfügen
        this.raum[i] = raum;
        System.out.println("Der Raum wurde erfolgreich angelegt und gespeichert");
        break;
      }
    }

    // das gesamte Array abspeichern
    speicherRaum(this.raum);
  }

  @Override
  //Array an Räumen aus der Datei laden
  public Raum[] getRaum() {
    Datenbank data = new Datenbank();
    this.raum = data.ladeRaum();
    return raum;
  }

  //ToDo Methode ist redundant auf Sinnhaftigkeit prüfen
  @Override
  public Raum createRaum(int sitzplaetze, String raumnummer) {
    Raum neuerRaum = new Raum(sitzplaetze, raumnummer);
    return neuerRaum;
  }

  @Override
  //Raum Array auf die Konsole ausgeben
  public String showRaumuebersicht() {
    String ausgabe = "";

    for (int i = 0; i < raum.length; i++){
      if (raum[i] != null){
        ausgabe += raum[i].toString() + "\n";
      }
    }
    return ausgabe;
  }

  @Override
  //Einen Raum über die RaumID löschen
  public void removeRaum(String raumnummer) {
    for (int i = 0; i < raum.length; i++) {

      if (raum[i] == null){
        continue;
      }

      if (raum[i].getRaumnummer().equals(raumnummer)) {
        raum[i] = null;
      }
    }
   speicherRaum(raum);
  }

  public boolean compareRaum(Raum raumNeu) {
    for (int i = 0; i < raum.length; i++) {

      if (raum[i] == null){
        continue;
      }

      if (raum[i].getRaumnummer().equals(raumNeu.getRaumnummer())) {
        return true;
      }

    }
    return false;
  }

  //Raum Array in die XML Datei Speichern
  public void speicherRaum(Raum[] raum){
    Datenbank data = new Datenbank();
    data.setTmpRaum(raum);
    data.speicherRaum();
  }
}


