package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;

import java.util.Date;

public class Raumbuchungssystem implements IRaumbuchungssystem {

  Buchung[] buchungen = new Buchung[999];

  @Override
  public Buchung[] getBuchung() {
    Datenbank data = new Datenbank();
    this.buchungen = data.ladeBuchung();
    return buchungen;
  }

  @Override
  public void removeBuchung(int buchungsID) {
    for (int i = 0; i < buchungen.length; i++) {

      if (buchungen[i] == null) {
        continue;
      }

      if (buchungen[i].getBuchungsID() == buchungsID) {
        buchungen[i] = null;
      }
      // Methode speicherBenutzer aufrufen und User Array in XML- Datei speichern
      speicherBuchung(buchungen);
    }
  }

  @Override
  public void addBuchung(Buchung buchung) {
    for (int i = 0; i < buchungen.length; i++) {
      if (buchungen[i] == null) {
        buchungen[i] = buchung;
        System.out.println("Buchung wurde erfolgreich registriert");
      }
      break;
    }
    speicherBuchung(buchungen);
  }

  @Override
  public Buchung createBuchung(Benutzer benutzer, Raum raum, int zeitraum, Date datum) {
    Buchung neueBuchung = new Buchung(benutzer, raum, zeitraum, datum);
    return neueBuchung;
  }

  public void speicherBuchung(Buchung[] buchungen) {
    Datenbank data = new Datenbank();
    data.setTmpBuchung(buchungen);
    data.speicherBuchung();
  }

  public boolean compareBuchung(Buchung buchung) {
    for (int i = 0; i < buchungen.length; i++) {
      if (buchungen[i].getRaum().getRaumnummer().equals(buchung.getRaum().getRaumnummer()) &&
              buchungen[i].getZeitraum() == buchung.getZeitraum() &&
              buchungen[i].getDatum().getDate() == buchung.getDatum().getDate() &&
              buchungen[i].getDatum().getMonth() == buchung.getDatum().getMonth() &&
              buchungen[i].getDatum().getYear() == buchung.getDatum().getYear()) {
        return true;
      }
    }
    return false;
  }

  public String ausgabeBuchungen() {
    String ausgabe = "";

    for (int i = 0; i < buchungen.length; i++) {
      if (buchungen[i] == null) {
        continue;
      }
      ausgabe += buchungen[i];
    }
    return ausgabe;
  }


  public String ausgabeZeitraum() {
    String ausgabe = "";
    for (int i = 1; i <= 10 ; i++){
      ausgabe += "Zeiraum " + i + " von " + (i+6) + " bis " + (i+7) + " Uhr" + "\n";
    }
    return ausgabe;
  }

}