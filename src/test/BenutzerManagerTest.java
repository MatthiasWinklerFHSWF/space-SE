package Test;

import Domainmodell.Benutzer;
import Domainmodell.Raum;
import Logic.Benutzermanager;
import Logic.Raummanager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenutzerManagerTest {

    //Anlegen Objekte zum testen
    Benutzermanager bm = new Benutzermanager();
    Benutzer user1 = new Benutzer("Test", "1234");
    Benutzer user2 = new Benutzer("Lol", "12345");


    @Test
    //Test Methode für Benutzer hinzufügen
    public void TestAddBeutzer(){
        //Benutzer hinzufügen
        bm.addBenutzer(user1);
        //konnte der Benutzer hinzugefügt werden?
        Assert.assertTrue(bm.compareBenutzer(user1));
    }


    @Test
    //Test Methode für Benutzer löschen
    public void TestRemoveBenuzter(){
        //Benutzer ins Array hinzufügen
        bm.addBenutzer(user1);
        bm.addBenutzer(user2);

        //Benutzer lösachen
        bm.removeBenutzer("Lol");
        //konnte der Benutzer gelöscht werden ?
        Assert.assertFalse(bm.compareBenutzer(user2));

    }

}
