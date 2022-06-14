package Domainmodell;

public class Benutzer {

    private String name;
    private Zugriffsrecht zugriffsrecht;
    private String passwort;

    public Benutzer(String name, String passwort, Zugriffsrecht zugriffsrecht){
        this.name = name;
        this.zugriffsrecht = zugriffsrecht;
        this.passwort = passwort;
    }



}
