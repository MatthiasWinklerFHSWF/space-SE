package UI;

import Domainmodell.Benutzer;
import Domainmodell.Benutzerrolle;
import Domainmodell.Raum;
import Logic.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {


  public static String anzeigenAuswahl(){
    String ausgabe = "";
    ausgabe += "\nBitte geben Sie entsprechend ein \n" + "1. Buchungsystem anzeigen \n" + "2. Benutzerverwaltung anzeigen \n" + "3. Raumverwaltung anzeigen \n";
    return ausgabe;
  }

  public static String anzeigenAuswahlRaum(){
    String ausgabe = "";
    ausgabe += "\nBitte geben Sie entsprechend ein \n" + "1. hinzufügen Raum \n" + "2. löschen Raum \n" + "3. anzeigen Raumüberischt \n";
    return ausgabe;
  }

  public static void runRMBS() {

    String input = "";
    String ausgabe = "";

    Benutzermanager bm = new Benutzermanager();
    Raummanager rm = new Raummanager();
    Raumbuchungssystem rbs = new Raumbuchungssystem();

    bm.getBenutzer();
    rm.getRaum();
    rbs.getBuchung();

    // Login Benutzer
    do {
      bm.logInBenutzer();
    } while (!bm.logInBenutzer());

    // bm.logInBenutzer();

    // 1. Auswahlmenü anbieten
    System.out.print(anzeigenAuswahl());

    input = eingabeConsole();

    if(input.equals('3')){
      // 2. Auswahlmenü anbieten
      System.out.println(anzeigenAuswahlRaum());
    }

    input = eingabeConsole();



    System.out.println("Es wurde " + input + " eingegeben");

  }



  public static String eingabeConsole() {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    // sc.close();
    return name;
  }

  public static void main(String[] args) {
    // System.out.println("Hallo");

    // System.out.print(eingabeConsole());
    /*

    Raum raum1 = new Raum(10,"10");
    Raum raum2 = new Raum(20,"20");
    Raum raum3 = new Raum(30,"30");

    IRaummanager rm = new Raummanager();

    rm.addRaum(raum1);
    rm.addRaum(raum2);
    rm.addRaum(raum3);

    System.out.println(rm.showRaumuebersicht());
    System.out.println("Hier leer???");
    rm.getRaum();
    System.out.println(rm.showRaumuebersicht());

    // Raum[] rooms = rm.getRaum();

    IBenutzermanager bm = new Benutzermanager();
    Benutzer mw = new Benutzer("Matthias", "123");
    Benutzer mg = new Benutzer("Mika", "1234");
    Benutzer lr = new Benutzer("Leonie", "12345");

    bm.addBenutzer(mw);
    bm.addBenutzer(mg);
    bm.addBenutzer(lr);

    bm.getBenutzer();
    System.out.print(bm.showBenutzer());

    bm.logInBenutzer();
    */

    runRMBS();




  }
}
