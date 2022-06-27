package Logic;

import Domainmodell.Benutzer;

public interface IBenutzermanager {

    void addBenutzer(Benutzer benutzer);

    void removeBenutzer(String name);

    Benutzer[] getBenutzer(String name);

    Benutzer createBenutzer(String name, String passwort);

}
