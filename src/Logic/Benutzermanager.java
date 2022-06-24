package Logic;

import Domainmodell.Benutzer;

public class Benutzermanager implements IBenutzermanager{

    @Override
    public Benutzer[] getBenutzer(String name) {
        return new Benutzer[0];
    }

    @Override
    public void addBenutzer(String name, String passwort) {

    }

    @Override
    public void removeBenutzer(String name) {

    }
}
