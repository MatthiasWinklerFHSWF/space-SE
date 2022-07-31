package Test;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;
import Logic.Raumbuchungssystem;
import Logic.Raummanager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RaumbuchungssystemTest {

    //Anlegen Objekte um eine Buchung anzulegen
    Raumbuchungssystem rmbs = new Raumbuchungssystem();
    Raum raum1 = new Raum(25, "102");
    Benutzer user1 = new Benutzer("Test", "1234");

    //Eine Buchung erstellen
    Buchung buchung1 = new Buchung(user1, raum1, 5, Buchung.createDate(2022, 5, 10));


    @Test
    //Test Methode für Buchung hinzufügen
    public void addBuchungTest(){
        //Buchung hinzufügen
        rmbs.addBuchung(buchung1);
        //Wurde eine Buchung hinzugefügt ?
        Assert.assertTrue(rmbs.compareBuchung(buchung1));
    }

    @Test
    //Test Methode um eine Buchung zu löschen
    public void removeBuchungTest(){
        //Eine Buchung hinzufügen
        rmbs.addBuchung(buchung1);

        //Buchung entfernen
        //Für eine perfekte funktion muss die BuchungsID überarbeitet werden.
        //Wenn die BuchungsID in der Buchung angegeben ist und dann übergeben wird ist der Test TRUE!!
        rmbs.removeBuchung(1);
        //Wurde die Buchung im Array gefunden ?
        Assert.assertFalse(rmbs.compareBuchung(buchung1));
    }
}
