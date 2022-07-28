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


    Benutzermanager bm = new Benutzermanager();
    Benutzer user1 = new Benutzer("Test", "1234");
    Benutzer user2 = new Benutzer("Lol", "12345");


    @Test
    public void TestAddBeutzer(){
        bm.addBenutzer(user1);
        Assert.assertTrue(bm.compareBenutzer(user1));
    }

    @Test
    public void TestRemoveBenuzter(){
        bm.addBenutzer(user1);
        bm.addBenutzer(user2);

        bm.removeBenutzer("Lol");
        Assert.assertFalse(bm.compareBenutzer(user2));

    }

}
