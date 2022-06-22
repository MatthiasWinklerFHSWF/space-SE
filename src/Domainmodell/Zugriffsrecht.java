package Domainmodell;

public class Zugriffsrecht {

    boolean admin;
    boolean verwaltenRaum;
    boolean verwaltenBenutzer;
    boolean buchenRaum;

    public Zugriffsrecht(boolean admin, boolean verwaltenRaum, boolean verwaltenBenutzer, boolean buchenRaum){
        this.admin = admin;
        this.verwaltenRaum = verwaltenRaum;
        this.verwaltenBenutzer = verwaltenBenutzer;
        this.buchenRaum = buchenRaum;
    }

    public void setOne(){
        this.admin = true;
        this.verwaltenRaum = true;
        this.verwaltenBenutzer = true;
        this.buchenRaum = true;
    }

}
