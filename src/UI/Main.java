package UI;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;
import Logic.*;

import java.util.Date;
import java.util.Scanner;

public class Main {


  public static void anzeigenWillkommen(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    //String ausgabe = "Willkommen im Raumbuchungssystem der FH SWF" + "\n";1
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
    ausgabe += "\n"+ "Bitte geben Sie entsprechend ein \n" + "1. Buchung erstellen \n" + "2. Buchung löschen \n" + "3. Buchungsübersicht anzeigen \n" + "4. Zurück zur Auswahl";
    System.out.println(ausgabe);
    eingabeAuswahlBuchung(bm, rm, rbs);
  }

  public static void eingabeAuswahlBuchung(Benutzermanager bm, Raummanager rm, Raumbuchungssystem rbs){
    String input = eingabeConsole();

  if (input.equals("1")){
    rbs.addBuchung(erstelleBuchung(bm, rm, rbs));
    anzeigenAuswahlBuchung(bm, rm, rbs);
  }
 if (input.equals("2")){
   anzeigenAuswahlBuchung(bm, rm, rbs);
 }
 //TODO überarbeiten oder ergänzen um Methode Ausgabe nur eigene Buchungen
    if (input.equals("3")){
      System.out.println(rbs.ausgabeBuchungen());
      anzeigenAuswahlBuchung(bm, rm, rbs);
    }
    if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")){
      System.out.println("Keine gültige Eingabe");
      anzeigenAuswahlBuchung(bm, rm, rbs);
    }
  }

  public static Buchung erstelleBuchung(Benutzermanager bm, Raummanager rm,Raumbuchungssystem rbs){
    Buchung newBuchung = null;
    // Benutzer für Buchung erfassen
    // TODO Benutzer über Benutzerlogin erfassen
    System.out.println ("Bitte geben Sie ihren Benutzernamen ein:");
    String name = eingabeConsole();
    Benutzer benutzer = bm.searchBenutzer(name);
    // Raum für Raumnummer erfassen
    System.out.println("Bitte geben Sie den gewünschten Raum ein:");


    String nummer = eingabeConsole();
    Raum raum = rm.searchRaum(nummer);

    // Eingabe Datum
    System.out.println("Bitte geben Sie ein Datum ein: \n");
    System.out.print("Jahr: ");
    int jahr = Integer.parseInt(eingabeConsole());
    System.out.print("Monat: ");
    int monat = Integer.parseInt(eingabeConsole());
    System.out.print("Tag: ");
    int tag = Integer.parseInt(eingabeConsole());
    Date datum = Buchung.createDate(jahr, monat, tag);

    // Zeitraum eingeben
    System.out.println("Bitte geben Sie den gewünschten Zeitraum ein:");
    System.out.println(rbs.ausgabeZeitraum());
    int zeitraum = Integer.parseInt(eingabeConsole());
    newBuchung = rbs.createBuchung(benutzer, raum, zeitraum, datum);

    return newBuchung;
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

  }

  public static String eingabeConsole() {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    // sc.close();
    return name;
  }

  public static void main(String[] args) {

    runRMBS();

  }
}
