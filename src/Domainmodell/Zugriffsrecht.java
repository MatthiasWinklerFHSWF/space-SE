package Domainmodell;

public class Zugriffsrecht {
    // Variablen für Zugriffsrecht

    boolean admin;
    boolean verwaltenRaum;
    boolean verwaltenBenutzer;
    boolean buchenRaum;

    // Konstruktor
    public Zugriffsrecht(boolean admin, boolean verwaltenRaum, boolean verwaltenBenutzer, boolean buchenRaum){
        this.admin = admin;
        this.verwaltenRaum = verwaltenRaum;
        this.verwaltenBenutzer = verwaltenBenutzer;
        this.buchenRaum = buchenRaum;
    }
    // Test alle Zugriffsrechte gewähren
    public void setOne(){
        this.admin = true;
        this.verwaltenRaum = true;
        this.verwaltenBenutzer = true;
        this.buchenRaum = true;
    }

}
