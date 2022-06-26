package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Raum;

public interface IBenutzermanager {

    void addBenutzer(String name, String passwort);

    void removeBenutzer(String name);

    Benutzer[] getBenutzer(String name);
}
