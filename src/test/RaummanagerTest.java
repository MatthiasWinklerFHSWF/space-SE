package test;

import Domainmodell.Raum;
import Logic.Raummanager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaummanagerTest {


    Raummanager rm = new Raummanager();
    Raum raum1 = new Raum(25, "102");
    Raum raum2 = new Raum(25, "103");
    Raum raum3 = new Raum(25, "104");

    // Testen ob beim hinzufügen nachher mehr Räume vorhanden sind
    @Test
    public void TestAddRoom(){
        assertEquals(rm.addRaum(raum1));
    }

    /*
    // Keine Duplikate
    //@Test
    public void TestAddRoom(){

    }

     */
}
