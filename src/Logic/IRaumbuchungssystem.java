package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

public interface IRaumbuchungssystem {
  void addBuchung(Buchung buchung);

  void removeBuchung(int buchungsID);

  Buchung[] getBuchung();

  Buchung createBuchung(int buchungsID, Benutzer benutzer, Raum raum, int zeitraum);
}
