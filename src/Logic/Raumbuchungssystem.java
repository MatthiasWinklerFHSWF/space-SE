package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

public class Raumbuchungssystem implements IRaumbuchungssystem {

  Buchung[] buchungen = new Buchung[999];

  @Override
  public Buchung[] getBuchung() {
    return new Buchung[0];
  }

  @Override
  public void removeBuchung(int buchungsID) {}

  @Override
  public void addBuchung(Buchung buchung) {
    for (int i = 0; i < buchungen.length; i++) {
      if (buchungen[i] == null) {
        buchungen[i] = buchung;
      }
    }
  }

  @Override
  public Buchung createBuchung(int buchungsID, Benutzer benutzer, Raum raum, int zeitraum) {
    Buchung neueBuchung = new Buchung(buchungsID, benutzer, raum, zeitraum);
    return neueBuchung;
  }
}
