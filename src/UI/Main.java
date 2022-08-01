package UI;

import Domainmodell.Benutzer;
import Logic.*;

import java.util.Scanner;

public class Main {


  public static void anzeigenWillkommen(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    //String ausgabe = "Willkommen im Raumbuchungssystem der FH SWF" + "\n";
    String ausgabe = "bitte wählen Sie aus:" + "\n";
    ausgabe += "1. Login" + "\n";
    ausgabe += "2. Registrieren";
    System.out.println(ausgabe);
    eingabeWillkommen(bm, rm, rbs);

  }

  public static void eingabeWillkommen(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String input = eingabeConsole();

    if (input.equals("1")){
      loopLogin(bm);
    }

    if (input.equals("2")){
      System.out.println("Als neuer Nutzer registrieren:");
      System.out.println("Bitte geben Sie ihren Name ein:");
      String name = eingabeConsole();
      System.out.println("Bitte geben Sie ein Passwort ein:");
      String passwort = eingabeConsole();

      // Benutzer mit create erzeugen
      // ToDo redundant mit normalen Konstruktor überarbeiten
      Benutzer temp = bm.createBenutzer(name, passwort);
      bm.addBenutzer(temp);

      if (bm.compareBenutzer(temp)){
        anzeigenWillkommen(bm, rm, rbs);

      }
    }

    if (!input.equals("1") && !input.equals("2")){
      System.out.println("Keine gültige Eingabe");
      anzeigenWillkommen(bm, rm, rbs);
    }

  }

  public static void loopLogin(Benutzermanager bm){
    boolean login;
    do {
      login = false;
      login = bm.logInBenutzer();
    } while (!login);
  }

  public static void anzeigenAuswahlMenu(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){

    String ausgabe = "";
    boolean bool = false;
    ausgabe += "\nBitte geben Sie entsprechend ein \n" + "1. Buchungsystem anzeigen \n" + "2. Benutzerverwaltung anzeigen \n" + "3. Raumverwaltung anzeigen \n";
    System.out.println(ausgabe);
    do {
      bool = eingabeAuswahlMenu(bm, rm, rbs);
    } while(bool);
  }

  public static boolean eingabeAuswahlMenu(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){

    String input = eingabeConsole();

    if(input.equals("1")){
      // 1. Auswählmenü Buchungssystem
      System.out.println("Auswahl << Buchungsystem >> wurde ausgewählt");
      anzeigenAuswahlBuchung(bm, rm, rbs);
      return true;
    }

    if(input.equals("2")){
      // 2. Auswahlmenü Benutzerverwaltung
      System.out.println("Auswahl << Benutzerverwaltung >> wurde ausgewählt");
      anzeigenAuswahlBenutzer(bm, rm, rbs);
      return true;
    }

    if(input.equals("3")){
      // 3. Auswahlmenü Raumverwaltung
      System.out.println("Auswahl << Raumverwaltung >> wurde ausgewählt");
      anzeigenAuswahlRaum(bm, rm, rbs);
      return true;
    }
    return false;
  }

  public static void anzeigenAuswahlRaum(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String ausgabe = "";
    ausgabe += "\n"+ "Bitte geben Sie entsprechend ein \n" + "1. hinzufügen Raum \n" + "2. löschen Raum \n" + "3. anzeigen Raumüberischt \n" + "4. Zurück zur Auswahl";
    System.out.println(ausgabe);
    eingabeAuswahlRaum(bm, rm, rbs);
  }

  public static void eingabeAuswahlRaum(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String input = eingabeConsole();
    boolean bool = false;

    if(input.equals("1")) {
      // 1. Auswahlmenü Raum hinzufügen
      System.out.println("Auswahl << Raum hinzufügen >> wurde ausgewählt");

      do {
        bool = eingabeAuswahladdRaum(bm, rm, rbs);
      } while(!bool);
      anzeigenAuswahlRaum(bm, rm, rbs);
    }

    if(input.equals("2")){
      // 2. Auswahlmenü Raum löschen
      System.out.println("Auswahl << Raum löschen >> wurde ausgewählt");
      eingabeAuswahlremoveRaum(rm);
      anzeigenAuswahlRaum(bm, rm, rbs);
    }

    if(input.equals("3")){
      // 3. Auswahlmenü Raumübersicht anzeigen
      System.out.println("Auswahl << Raumübersicht anzeigen >> wurde ausgewählt");
      System.out.println(rm.showRaumuebersicht());
      anzeigenAuswahlRaum(bm, rm, rbs);
    }

    if (input.equals("4")){
      // 4. zurück zum Auswahlmenü
      anzeigenAuswahlMenu(bm, rm, rbs);
    }

    if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")){
      System.out.println("Keine gültige Eingabe");
      anzeigenAuswahlRaum(bm, rm, rbs);
    }
  }

   public static void anzeigenAuswahlBenutzer(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String ausgabe = "";
    ausgabe += "\n"+ "Bitte geben Sie entsprechend ein \n" + "1. Benutzer löschen \n" + "2. Zurück zur Auswahl";
    System.out.println(ausgabe);
    eingabeAuswahlBenutzer(bm, rm, rbs);
  }

  public static void eingabeAuswahlBenutzer(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String input = eingabeConsole();

    // ToDo nur Eingabe des eigenen Benutzers + Passwort
    if (input.equals("1")){
      System.out.println("Bitte geben Sie den Benutzernamen zum löschen ein:");
      String benutzer = eingabeConsole();
      bm.removeBenutzer(benutzer);
      anzeigenWillkommen(bm, rm, rbs);
    }

    if (input.equals("2")){
      // 4. zurück zum Auswahlmenü
      anzeigenAuswahlMenu(bm, rm, rbs);
    }

    if (!input.equals("1") && !input.equals("2")){
      System.out.println("Keine gültige Eingabe");
      anzeigenAuswahlBenutzer(bm, rm, rbs);
    }
  }

  public static void anzeigenAuswahlBuchung(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String ausgabe = "";
    ausgabe += "\n"+ "Bitte geben Sie entsprechend ein \n" + "1. Benutzer löschen \n" + "2. Zurück zur Auswahl";
    System.out.println(ausgabe);
    eingabeAuswahlBuchung(bm, rm, rbs);
  }

  public static void eingabeAuswahlBuchung(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String input = eingabeConsole();

  }

  public static boolean eingabeAuswahladdRaum(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    System.out.println("Bitte geben Sie die Anzahl an Sitzplätzen an:");

    // Sitzplätze als String erhalten und in int umwandeln
    String inputSitz = eingabeConsole();
    int inputSitzInt = Integer.parseInt(inputSitz);

    // Raumnummer als String erhalten
    System.out.println("Bitte geben Sie die Raumnummer an:");
    String inputRaumnummer = eingabeConsole();


    // Raum  erstellen und hinzufügen
    // speichert in xml durch Benutzermanager
    rm.addRaum(rm.createRaum(inputSitzInt, inputRaumnummer));

    return true;
  }

  public static void eingabeAuswahlremoveRaum(Raummanager rm){
    System.out.println("Bitte geben Sie die Raumnummer an:");
    String input = eingabeConsole();
    rm.removeRaum(input);
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

    // Abfrage Login Benutzer oder Neuer Benutzer anlegen
    anzeigenWillkommen(bm, rm, rbs);

    // 1. Auswahlmenü anbieten
    anzeigenAuswahlMenu(bm, rm, rbs);


    // ToDo: Methode erstellen für Rückgabe bei falscher Eingabe
    /*

    if (!input.equals("1") || !input.equals("2") || !input.equals("3")){
      System.out.println("Keine gültige Eingabe");
      System.out.print(anzeigenAuswahl());
      input = eingabeConsole();
    }



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
  */
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
    /*


    /*
    // Test Buchung
    Benutzer benutzer = new Benutzer("Mika", "1234");
    Raum raum = new Raum(10,"10");
    Date datum = Buchung.createDate(2020, 5, 12);
    Buchung abc = new Buchung(benutzer, raum, 1, datum);

    // System.out.println(datum);
    System.out.println(abc);
    */

    runRMBS();

  }
}
