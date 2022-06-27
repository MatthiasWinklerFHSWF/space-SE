package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

public class Datenbank implements IDatenbank {

  Benutzer[] benutzer = new Benutzer[999];
  Buchung[] buchung = new Buchung[999];
  Raum[] raum = new Raum[999];

  @Override
  public void speicherRaum(Raum[] raum) {}

  @Override
  public void speicherBuchung(Buchung[] buchung) {}

  @Override
  public void speicherBenutzer(Benutzer benutzer) {}

  @Override
  public void speicherBenutzer(Benutzer[] benutzer) {}

  @Override
  public void speicherBuchung(Buchung buchung) {}

  @Override
  public void speicherRaum(Raum raum) {}

  @Override
  public Benutzer[] ladeBenutzer() {
    return new Benutzer[0];
  }

  @Override
  public Buchung[] ladeBuchung() {
    return new Buchung[0];
  }

  @Override
  public Raum[] ladeRaum() {
    return new Raum[0];
  }
}
