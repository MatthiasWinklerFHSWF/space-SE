package Test;

import Domainmodell.Raum;
import Logic.Raummanager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaummanagerTest {


    //Anlegen Objekte zum testen
    Raummanager rm = new Raummanager();
    Raum raum1 = new Raum(25, "102");
    Raum raum2 = new Raum(25, "103");
    Raum raum3 = new Raum(25, "104");

    // Testen ob beim Hinzufügen nachher mehr Räume vorhanden sind


    @Test
    //Test Methode für Raum hinzufügen
    public void TestAddRoom(){
        //Raum hinzufügen
        rm.addRaum(raum1);
        //Wurde ein Raum hinzugefügt ?
        Assert.assertTrue(rm.compareRaum(raum1));
    }

    @Test
    public void TestAddRoomZwei(){
        //wurde ein Raum gefunden der nicht hinzugefügt wurde?
        Assert.assertTrue(rm.compareRaum(raum1));
    }



    @Test
    //Test Methode für Raum löschen
    public void TestRemoveRaum(){
        //Räume ins Array hinzufügen
        rm.addRaum(raum1);
        rm.addRaum(raum2);

        //Raum löschen
        rm.removeRaum("102");
        //konnte der Raum gelöscht werden ?
        Assert.assertFalse(rm.compareRaum(raum1));
    }

}
