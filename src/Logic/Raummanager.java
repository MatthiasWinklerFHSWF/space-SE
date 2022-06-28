package Logic;

import Domainmodell.Raum;

public class Raummanager implements IRaummanager {

  Raum[] raum = new Raum[999];

  @Override
  public void addRaum(Raum raum) {

    // ToDo: Exists in Methode ExistsRoom umwandeln
    boolean exists = false;

    // überprüfen ob der Raum bereits exisitiert
    for (int i = 0; i < this.raum.length; i++){
      if ( (this.raum[i] != null) && (this.raum[i].getRaumnummer().equals(raum.getRaumnummer()))){
          System.out.println("Raum bereits vorhanden - hinzufügen fehlgeschlagen");
          exists = true;
          break;
      }
    }

    // den Raum an die nächste freie Stelle im Array einfügen
    for (int i = 0; i < this.raum.length; i++) {
      if (this.raum[i] == null && !exists) {
        this.raum[i] = raum;
        System.out.println("Der Raum wurde erfolgreich angelegt und gespeichert");
        break;
      }
    }

    // das gesamte Array abspeichern
    speicherRaum(this.raum);
  }

  @Override
  public Raum[] getRaum() {
    Datenbank data = new Datenbank();
    this.raum = data.ladeRaum();
    return raum;
  }

  @Override
  public Raum createRaum(int sitzplaetze, String raumnummer) {
    Raum neuerRaum = new Raum(sitzplaetze, raumnummer);
    return neuerRaum;
  }

  @Override
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
  public void removeRaum(int raumID) {
    for (int i = 0; i < raum.length; i++) {
      if (raum[i].getRaumID() == raumID) {
        raum[i] = null;
      }
    }
   speicherRaum(raum);
  }

  public void speicherRaum(Raum[] raum){
    Datenbank data = new Datenbank();
    data.setTmpRaum(raum);
    data.speicherRaum();
  }
}


