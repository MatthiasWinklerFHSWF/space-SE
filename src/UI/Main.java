package UI;

import Domainmodell.Benutzer;
import Domainmodell.Benutzerrolle;
import Domainmodell.Raum;
import Logic.*;

import java.util.Scanner;

public class Main {

  public static String eingabeConsole() {
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();
    // sc.close();
    return name;
  }

  public static void main(String[] args) {
    // System.out.println("Hallo");

    // System.out.print(eingabeConsole());

    Raum raum1 = new Raum(10,"10");
    Raum raum2 = new Raum(20,"20");
    Raum raum3 = new Raum(30,"30");

    IRaummanager rm = new Raummanager();

    /*
    rm.addRaum(raum1);
    rm.addRaum(raum2);
    rm.addRaum(raum3);
     */



    System.out.println(rm.showRaumuebersicht());
    System.out.println("Hier leer???");
    rm.getRaum();
    System.out.println(rm.showRaumuebersicht());




    // Raum[] rooms = rm.getRaum();

    IBenutzermanager bm = new Benutzermanager();
    Benutzer mw = new Benutzer("Matthias", "123");
    Benutzer mg = new Benutzer("Mika", "1234");
    Benutzer lr = new Benutzer("Leonie", "12345");

    /*
    bm.addBenutzer(mw);
    bm.addBenutzer(mg);
    bm.addBenutzer(lr);
    */

    bm.getBenutzer();
    System.out.print(bm.showBenutzer());

    bm.logInBenutzer();





  }
}
