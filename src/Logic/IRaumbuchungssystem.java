package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

import java.util.Date;

public interface IRaumbuchungssystem {

  void addBuchung(Buchung buchung);

  void removeBuchung(int buchungsID);

  Buchung[] getBuchung();

  Buchung createBuchung(Benutzer benutzer, Raum raum, int zeitraum, Date datum);


}
