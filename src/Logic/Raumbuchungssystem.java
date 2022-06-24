package Logic;


import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

import java.util.Date;

public class Raumbuchungssystem implements IRaumbuchungssystem {

    @Override
    public Buchung[] getBuchung() {
        return new Buchung[0];
    }

    @Override
    public void removeBuchung(int buchungsID) {

    }

    @Override
    public void addBuchung(Benutzer benutzer, Raum raum, Date datum, int zeitraum) {

    }


}
