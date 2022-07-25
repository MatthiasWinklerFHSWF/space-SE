package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

public class Raumbuchungssystem implements IRaumbuchungssystem {

  Buchung[] buchungen = new Buchung[999];

  @Override
  public Buchung[] getBuchung() {
    Datenbank data = new Datenbank();
    this.buchungen = data.ladeBuchung();
    return buchungen;
  }

  @Override
  public void removeBuchung(int buchungsID) {}

  @Override
  public void addBuchung(Buchung buchung) {
    for (int i = 0; i < buchungen.length; i++) {
      if (buchungen[i] == null) {
        buchungen[i] = buchung;
      }
      break;
    }
    // Datenbank.speicherBuchung(buchungen);
  }

  @Override
  public Buchung createBuchung(int buchungsID, Benutzer benutzer, Raum raum, int zeitraum) {
    Buchung neueBuchung = null;
    return neueBuchung;
  }

  public void speicherBuchung(Buchung[] buchungen){
    Datenbank data = new Datenbank();
    data.setTmpBuchung(buchungen);
    data.speicherBuchung();
  }

}
