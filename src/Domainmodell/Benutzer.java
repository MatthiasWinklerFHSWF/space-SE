package Domainmodell;

public class Benutzer {

  private final String name;
  private final Zugriffsrecht zugriffsrecht;
  private final String passwort;

  public Benutzer(String name, String passwort) {
    this.name = name;
    this.zugriffsrecht = null;
    this.passwort = passwort;
  }

  public String getName() {
    return name;
  }
}
