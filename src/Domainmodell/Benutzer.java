package Domainmodell;

public class Benutzer {

    private String name;
    private Zugriffsrecht zugriffsrecht;
    private String passwort;

    public Benutzer(String name, String passwort){
        this.name = name;
        this.zugriffsrecht = null;
        this.passwort = passwort;
    }

}
