package Domainmodell;

public class Benutzer {

  private String name;
  private Zugriffsrecht zugriffsrecht;
  private String passwort;

  public Benutzer(){

  }

  public Benutzer(String name, String passwort) {
    this.name = name;
    this.zugriffsrecht = null;
    this.passwort = passwort;
  }

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

  public String toString(){
    String ausgabe = "";
    ausgabe += "Benutzername: " + getName() + ", Passwort: " + getPasswort() + "\n";
    return ausgabe;
  }

}

