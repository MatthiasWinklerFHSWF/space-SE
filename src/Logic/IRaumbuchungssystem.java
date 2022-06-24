package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

import java.util.Date;

public interface IRaumbuchungssystem {
    void addBuchung (Benutzer benutzer, Raum raum, Date datum, int zeitraum);

    void removeBuchung(int buchungsID);

    Buchung[] getBuchung();
}