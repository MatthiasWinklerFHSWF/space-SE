package Logic;

import Domainmodell.Benutzer;

public class Benutzermanager implements IBenutzermanager {

  public Benutzer[] user = new Benutzer[999];
  public Benutzer neuerBenutzer;

  @Override
  public Benutzer[] getBenutzer(String name) {
    return new Benutzer[0];
  }

  @Override
  public void addBenutzer(Benutzer benutzer) {
    for (int i = 0; i < user.length; i++) {
      if (user[i] == null) {
        user[i] = benutzer;
        break;
      }
    }
    // Datenbank.speicherBenutzer(benutzer);
  }

  @Override
  public Benutzer createBenutzer(String name, String passwort) {
    Benutzer neuerBenutzer = new Benutzer(name, passwort);
    return neuerBenutzer;
  }

  @Override
  public void removeBenutzer(String name) {
    for (int i = 0; i < user.length; i++) {
      if (user[i].getName() == name) {
        user[i] = null;
      }
      // saveUser
    }
  }
}
