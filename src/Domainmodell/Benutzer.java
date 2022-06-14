package Domainmodell;

public class Benutzer {

    String name;
    int zugriffsrecht;
    String passwort;

    public Benutzer(String name, String passwort){
        this.name = name;
        this.zugriffsrecht = 1;
        this.passwort = passwort;
    }



}
