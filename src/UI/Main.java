package UI;

import Domainmodell.Benutzer;
import Domainmodell.Benutzerrolle;
import Domainmodell.Raum;
import Logic.*;

import java.util.Scanner;

public class Main {


  public static String anzeigenAuswahl(){
    String ausgabe = "";
    ausgabe += "\nBitte geben Sie entsprechend ein \n" + "1. Buchungsystem anzeigen \n" + "2. Benutzerverwaltung anzeigen \n" + "3. Raumverwaltung anzeigen \n";
    return ausgabe;
  }

  public static void eingabeAuswahl(String input){
    if(input.equals("1")){
      // 1. Auswahlmenü anbieten
      System.out.println("Auswahl << Buchungsystem >> wurde ausgewählt");

    }

    if(input.equals("2")){
      // 2. Auswahlmenü anbieten
      System.out.println("Auswahl << Benutzerverwaltung >> wurde ausgewählt");
    }

    if(input.equals("3")){
      // 3. Auswahlmenü anbieten
      System.out.println("Auswahl << Raumverwaltung >> wurde ausgewählt");
      System.out.println(anzeigenAuswahlRaum());
    }
  }

  public static String anzeigenAuswahlRaum(){
    String ausgabe = "";
    ausgabe += "\nBitte geben Sie entsprechend ein \n" + "1. hinzufügen Raum \n" + "2. löschen Raum \n" + "3. anzeigen Raumüberischt \n";
    return ausgabe;
  }

  public static String eingabeAuswahlRaum(String input){

    if(input.equals("1")){
      // 1. Auswahlmenü anbieten
      System.out.println("Auswahl << hinzufügen Raum >> wurde ausgewählt");
      return input;
    }

    if(input.equals("2")){
      // 2. Auswahlmenü anbieten
      System.out.println("Auswahl << löschen Raum >> wurde ausgewählt");
      return input;
    }

    if(input.equals("3")){
      // 3. Auswahlmenü anbieten
      System.out.println("Auswahl << anzeigen Raumübersicht >> wurde ausgewählt");
      return input;
    }

    return input;
  }



  public static void runRMBS() {

    String inputA = "";
    String inputB = "";
    String ausgabe = "";
    int wert = 0;

    Benutzermanager bm = new Benutzermanager();
    Raummanager rm = new Raummanager();
    Raumbuchungssystem rbs = new Raumbuchungssystem();

    bm.getBenutzer();
    rm.getRaum();
    rbs.getBuchung();

    // Login Benutzer
    boolean login;
    do {
      login = false;
      login = bm.logInBenutzer();
    } while (!login);

    // bm.logInBenutzer();

    // 1. Auswahlmenü anbieten
    System.out.print(anzeigenAuswahl());
    inputA = eingabeConsole();

    // 2. Menü wird angezeigt
    eingabeAuswahl(inputA);


    // ToDo: Methode erstellen für Rückgabe bei falscher Eingabe
    /*

    if (!input.equals("1") || !input.equals("2") || !input.equals("3")){
      System.out.println("Keine gültige Eingabe");
      System.out.print(anzeigenAuswahl());
      input = eingabeConsole();
    }

    */

    // 3. Menü wird angezeigt
    inputB = eingabeConsole();

    // ToDo: in Methode umwandeln
    do {
      eingabeAuswahl(inputB);
      if (inputB.equals("1")){
        System.out.println("Bitte geben Sie die Anzahl an Sitzplätzen an:");
        String inputSitz = eingabeConsole();
        int inputSitzInt = Integer.parseInt(inputSitz);
        System.out.println("Bitte geben Sie die Raumnummer an:");
        String inputRaumnummer = eingabeConsole();
        rm.addRaum(rm.createRaum(inputSitzInt, inputRaumnummer));
      }

      if (inputB.equals("3")){
        System.out.print(rm.showRaumuebersicht());
      }

      System.out.println(anzeigenAuswahlRaum());
      inputB = eingabeConsole();

    } while(inputA.equals("3"));

    // 3. Menü wird angezeigt
    // inputB = eingabeConsole();
    // eingabeAuswahlRaum(inputB);




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

    rm.addRaum(raum1);

    // Raum[] rooms = rm.getRaum();

    /*

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
