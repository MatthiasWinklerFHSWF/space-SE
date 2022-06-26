package Logic;

import Domainmodell.Benutzer;

public class Benutzermanager implements IBenutzermanager{

    public Benutzer[] user = new Benutzer[999];
    public Benutzer neuerBenutzer;

    @Override
    public Benutzer[] getBenutzer(String name) {
        return new Benutzer[0];
    }

    @Override
    public void addBenutzer(String name, String passwort) {
        Benutzer neuerBenutzer = new Benutzer(name, passwort);

    }

    @Override
    public void removeBenutzer(String name) {

    }
}
