package UI;

import Domainmodell.Benutzerrolle;

public class Main {

  public static void main(String[] args) {
    // System.out.println("Hallo");

    Benutzerrolle student = new Benutzerrolle();
    student.istStudent();
    System.out.print(student);



  }
}
