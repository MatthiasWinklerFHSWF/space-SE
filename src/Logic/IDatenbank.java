package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

public interface IDatenbank {

  void speicherBuchung();

  void speicherRaum();

  void speicherBenutzer();

  Buchung[] ladeBuchung();

  Raum[] ladeRaum();

  Benutzer[] ladeBenutzer();
}
