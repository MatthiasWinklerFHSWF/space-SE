package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Raum;

import java.util.Scanner;

public class Benutzermanager implements IBenutzermanager {

  public Benutzer[] user = new Benutzer[999];
  public Benutzer neuerBenutzer;

  @Override
  public Benutzer[] getBenutzer() {
    Datenbank data = new Datenbank();
    this.user = data.ladeBenutzer();
    return this.user;
  }

  @Override
  public void addBenutzer(Benutzer benutzer) {
    for (int i = 0; i < user.length; i++) {
      if (user[i] == null) {
        user[i] = benutzer;
        break;
      }
    }
    speicherBenutzer(user);
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

  @Override
  public boolean logInBenutzer() {

    System.out.println("Login bitte geben Sie Benutzername und Passwort ein!");
    System.out.println("Benutzername:");
    String name = eingabeConsole();
    System.out.println("Passwort: ");
    String passwort = eingabeConsole();

    for (int i = 0; i < this.user.length; i++){

      if (user[i] == null) {
        continue;
      }

      if (user[i].getName().equals(name) && user[i].getPasswort().equals(passwort)){
        System.out.print("Login erfolgreich");
        return true;
      }
    }
    System.out.print("Login fehlgeschlagen - Benutzername oder Passwort falsch");
    return false;
}

  @Override
  public String showBenutzer() {
    String ausgabe = "";
    for (int i = 0; i < user.length; i++){
      if (user[i] != null){
      ausgabe += user[i];
      }
    }
    return ausgabe;
  }

  public void speicherBenutzer(Benutzer[] user){
    Datenbank data = new Datenbank();
    data.setTmpBenutzer(user);
    data.speicherBenutzer();
  }

  public String eingabeConsole() {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    // sc.close();
    return name;
  }

}
