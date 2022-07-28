package Test;

import Domainmodell.Raum;
import Logic.Raummanager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaummanagerTest {


    Raummanager rm = new Raummanager();
    Raum raum1 = new Raum(25, "102");
    Raum raum2 = new Raum(25, "103");
    Raum raum3 = new Raum(25, "104");

    // Testen ob beim hinzufügen nachher mehr Räume vorhanden sind


    @Test
    public void TestAddRoom(){
        rm.addRaum(raum1);
        Assert.assertTrue(rm.compareRaum(raum1));
    }

    @Test
    public void TestAddRoomZwei(){

        Assert.assertTrue(rm.compareRaum(raum1));
    }



    @Test
    public void TestRemoveRaum(){
        rm.addRaum(raum1);
        rm.addRaum(raum2);

        rm.removeRaum("102");
        Assert.assertFalse(rm.compareRaum(raum1));
    }

}
