package Logic;

import Domainmodell.Benutzer;

public interface IBenutzermanager {

    void addBenutzer(Benutzer benutzer);

    void removeBenutzer(String name);

    Benutzer[] getBenutzer();

    Benutzer createBenutzer(String name, String passwort);

    boolean logInBenutzer();

    String showBenutzer();

}
