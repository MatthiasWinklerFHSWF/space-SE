package test;

import Domainmodell.Raum;
import Logic.Raummanager;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaummanagerTest {


    Raummanager rm = new Raummanager();
    Raum raum1 = new Raum(25, "102");
    Raum raum2 = new Raum(25, "103");
    Raum raum3 = new Raum(25, "104");

    // Testen ob beim hinzufügen nachher mehr Räume vorhanden sind

    /*
    @Test
    public void TestAddRoom(){
        //Erstellt Objekt welches ins zum Test in Array eingefügt wird
        ResizingArray resizingArray = new ResizingArray(2);

        //Fügt das Objekt dem Array hinzu
        resizingArray.addRaum(raum1);
        //Überprüft ob das Objekt hinzugefügt wurde
        Assert.isTrue(resizingArray.length()== 1);

        resizingArray.addRaum(raum2);
        Assert.isTrue(resizingArray.length()== 2);

        //kann nur 2 hinzufügen, da resizing Objekt nur 2 groß
        resizingArray.addRaum(raum3);
        Assert.isTrue(resizingArray.length()== 3);
    }

    public void TestremoveRaum(){
        ResizingArray resizingArray = new ResizingArray(1);

        resizingArray.addRaum(raum1);
        Assert.isTrue(resizingArray.length()== 1);

        //RaumID einfügen um den Raum zu löschen
        resizingArray.removeRaum();
        Assert.isTrue(resizingArray.length()== 0);


    }

     */
}
