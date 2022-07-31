package Logic;

import Domainmodell.Benutzer;

import java.util.Scanner;

public class Benutzermanager implements IBenutzermanager {

  public Benutzer[] user = new Benutzer[999];

  @Override
  public Benutzer[] getBenutzer() {
    Datenbank data = new Datenbank();
    this.user = data.ladeBenutzer();
    return this.user;
  }

  // Methode um Benutzer hinzuzufügen
  @Override
  public void addBenutzer(Benutzer benutzer) {
    // die For Schleife durchläuft das User Array und an
    // der ersten freien Stelle wird der Benutzer eingefügt
    // nach dem einfügen wird die For Schleife verlassen
    // ToDo entweder Fehler Meldung wenn das Array voll ist oder Datenstruktur überarbeiten(ArrayList..)

    if (!compareBenutzer(benutzer)){
      for (int i = 0; i < user.length; i++) {
        if (user[i] == null) {
          user[i] = benutzer;
          break;
        }
      }
      // Methode speicherBenutzer aufrufen und User Array in XML- Datei speichern
      speicherBenutzer(user);
      System.out.println("Benutzer erfolgreich hinzugefügt");
    }
    System.out.println("Benutzername bereits vergeben - anlegen fehlgeschlagen");

  }

  // Methode um einen Benutzer zu erstellen
  //ToDo Methode ist redundant auf Sinnhaftigkeit prüfen
  @Override
  public Benutzer createBenutzer(String name, String passwort) {
    Benutzer neuerBenutzer = new Benutzer(name, passwort);
    return neuerBenutzer;
  }

  // Methode um den Benutzer zu entfernen
  @Override
  public void removeBenutzer(String name) {
    // For Schleife durchsucht das Array mit getName nach dem Namen
    // und setzt die Stelle im Array bei gleichem Namen auf null
    // ToDo Gefahr bei gleichem Namen das der falsche User gelöscht wird -> auf Benutzer ändern
    for (int i = 0; i < user.length; i++) {
      if (user[i].getName().equals(name)) {
        user[i] = null;
      }
      // Methode speicherBenutzer aufrufen und User Array in XML- Datei speichern
      speicherBenutzer(user);
    }
  }

  // Methode BenutzerLogin mit Abfrage
  @Override
  public boolean logInBenutzer() {
    // Konsolen ausgabe, Hinweis Login
    System.out.println("Login bitte geben Sie Benutzername und Passwort ein!");
    System.out.println("Benutzername:");
    // String Name über die Konsole einlesen -> Methode eingabeconsole wird aufgerufen
    String name = eingabeConsole();
    System.out.println("Passwort: ");
    // String Name über die Konsole einlesen -> Methode eingabeconsole wird aufgerufen
    String passwort = eingabeConsole();
    // For Schleife wird durchlaufen
    for (int i = 0; i < this.user.length; i++){
      // wenn der User an der Stelle i null ist dann continue
      if (user[i] == null) {
        continue;
      }
      // wenn der User an der Stelle i mit getName und getPasswort mit Name und Passwort übereinstimmt
      // dann wird true zurückgegeben und der Login ist erfolgreich
      if (user[i].getName().equals(name) && user[i].getPasswort().equals(passwort)){
        System.out.print("Login erfolgreich");
        return true;
      }
    }
    // wenn beim durchlaufen der For Schleife keine passenden Daten gefunden werden
    // wird false zurückgegeben und Hinweis auf der Konsole -> Login ist fehlgeschlagen
    System.out.print("<< Login fehlgeschlagen - Benutzername oder Passwort falsch >> \n");
    return false;
}
// gibt alle Benutzer zurück -> greift dazu auf die toString Methode von Benutzern zurück
  @Override
  public String showBenutzer() {
    String ausgabe = "";
    for (int i = 0; i < user.length; i++){
      // wenn der User nicht null ist, wird der User zur Ausgabe hinzugefügt
      if (user[i] != null){
      ausgabe += user[i];
      }
    }
    return ausgabe;
  }
// speichert den Benutzer
  public void speicherBenutzer(Benutzer[] user){
    // erzeugt ein leeres datenbank Objekt
    Datenbank data = new Datenbank();
    // fügt das User Array dem Datenbank Objekt hinzu
    data.setTmpBenutzer(user);
    // Methode speicherBenutzer aus der Klasse Datenbank aufrufen
    data.speicherBenutzer();
  }

// Hilfsmethode zum einlesen auf der Konsole
  public String eingabeConsole() {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    // sc.close();
    return name;
  }

  public boolean compareBenutzer(Benutzer benutzertest){
    for (int i = 0; i < user.length; i++) {

      if (user[i] == null){
        continue;
      }

      if (user[i].getName().equals(benutzertest.getName())){
        return true;
      }

    }
    return false;
  }

}
