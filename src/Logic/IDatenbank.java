package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

public interface IDatenbank {

  void speicherBuchung(Buchung[] buchung);

  void speicherBuchung(Buchung buchung);

  void speicherRaum(Raum[] raum);

  void speicherRaum(Raum raum);

  void speicherBenutzer(Benutzer[] benutzer);

  void speicherBenutzer(Benutzer benutzer);

  Buchung[] ladeBuchung();

  Raum[] ladeRaum();

  Benutzer[] ladeBenutzer();
}
