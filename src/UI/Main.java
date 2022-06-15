package UI;

import Domainmodell.Benutzerrolle;
import Domainmodell.Raum;
import Logic.IDT;
import Logic.Raumbuchungssystem;

public class Main {

    public static void main(String [] args){
        // System.out.println("Hallo");

        IDT idt = new Raumbuchungssystem();



        Raum neuerRaum = new Raum(10, true, false, 10, "A", "3B");
        System.out.print(neuerRaum.getRaumID());

        Raum neuerRaumZwei = new Raum(25, true, true, 20,"ABC", "2a");
        System.out.print(neuerRaumZwei.getRaumID());
        System.out.println();


        Benutzerrolle student = new Benutzerrolle();
        student.istStudent();
        System.out.print(student);

    }
}
