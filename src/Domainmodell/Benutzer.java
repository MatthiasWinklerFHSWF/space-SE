package Domainmodell;

public class Benutzer {
 // Benutzer Variablen
  private String name;
  // aktuell in Planung, Konstruktor momentan null
  private Zugriffsrecht zugriffsrecht;
  private String passwort;

  //leerer Konstruktor zur Datenbankerkennung
  public Benutzer(){

  }

  // ToDo Name als Benutzername als Unique ergänzen und zusätzlich Vorname und Nachname einfügen
  public Benutzer(String name, String passwort) {
    this.name = name;
    this.zugriffsrecht = null;
    this.passwort = passwort;
  }
// Methoden
  public String getName() {
    return name;
  }

  public String getPasswort(){
    return passwort;
  }

  public Zugriffsrecht getZugriffsrecht() {
    return zugriffsrecht;
  }

  public void setPasswort(String passwort) {
    this.passwort = passwort;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setZugriffsrecht(Zugriffsrecht zugriffsrecht) {
    this.zugriffsrecht = zugriffsrecht;
  }

  // toString zur Ausgabe von Benutzern
  public String toString(){
    String ausgabe = "";
    ausgabe += "Benutzername: " + getName() + ", Passwort: " + getPasswort() + "\n";
    return ausgabe;
  }

}