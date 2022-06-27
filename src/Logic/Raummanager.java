package Logic;

import Domainmodell.Raum;

public class Raummanager implements IRaummanager {

  Raum[] raeume = new Raum[999];

  @Override
  public void addRaum(Raum raum) {
    for (int i = 0; i < raeume.length;5 i++) {
      if (raeume[i] == null) {
        raeume[i] = raum;
        break;
      }
    }
    // Datenbank.speicherRaum(raeume);
  }

  @Override
  public Raum[] getRaeume(int raumID) {
    // >> Inhalte aus der Datenbank laden
    // raueme mit neuem Inhalt überschreiben
    // raeume = Datenbank.ladeRaum();
    return raeume;
  }

  @Override
  public Raum createRaum(int sitzplaetze, String raumnummer) {
    Raum neuerRaum = new Raum(sitzplaetze, raumnummer);
    return neuerRaum;
  }

  @Override
  public void removeRaum(int raumID) {
    for (int i = 0; i < raeume.length; i++) {
      if (raeume[i].getRaumID() == raumID) {
        raeume[i] = null;
      }
    }
    // Datenbank.speicherRaum(raeume);
  }
}
