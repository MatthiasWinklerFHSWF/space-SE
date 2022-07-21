package Logic;

import Domainmodell.Benutzer;
import Domainmodell.Buchung;
import Domainmodell.Raum;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Datenbank implements IDatenbank {
// Datenbank Variablen
  Raum[] tmpRaum = new Raum[999];
  Benutzer[] tmpBenutzer = new Benutzer[999];
  Buchung[] tmpBuchung = new Buchung[999];

  public Datenbank(){

  }

  public void setTmpBenutzer(Benutzer[] tmpBenutzer) {
    this.tmpBenutzer = tmpBenutzer;
  }

  public void setTmpBuchung(Buchung[] tmpBuchung) {
    this.tmpBuchung = tmpBuchung;
  }

  public void setTmpRaum(Raum[] tmpRaum) {
    this.tmpRaum = tmpRaum;
  }

  public Raum[] getTmpRaum() {
    return tmpRaum;
  }

  //Methode um Räume zu speichern
  @Override
  public void speicherRaum() {
    try{
      FileOutputStream fos = new FileOutputStream(new File("./raum.xml"));
      XMLEncoder encoder = new XMLEncoder(fos);
      for (int i = 0; i < tmpRaum.length; i++){
        encoder.writeObject(tmpRaum[i]);
      }
      encoder.close();
      fos.close();
    }
    catch(IOException ex){
      ex.printStackTrace();
    }

  }

  //Methode um Buchungen zu speichern
  @Override
  public void speicherBuchung() {

    try{
      FileOutputStream fos = new FileOutputStream(new File("./buchung.xml"));
      XMLEncoder encoder = new XMLEncoder(fos);
      for (int i = 0; i < tmpBuchung.length; i++){
        encoder.writeObject(tmpBuchung[i]);
      }
      encoder.close();
      fos.close();
    }
    catch(IOException ex){
      ex.printStackTrace();
    }

  }

  //Methode um Benutzer zu speichern
  @Override
  public void speicherBenutzer() {

    try{
      FileOutputStream fos = new FileOutputStream(new File("./benutzer.xml"));
      XMLEncoder encoder = new XMLEncoder(fos);
      for (int i = 0; i < tmpBenutzer.length; i++){
        encoder.writeObject(tmpBenutzer[i]);
      }
      encoder.close();
      fos.close();
    }
    catch(IOException ex){
      ex.printStackTrace();
    }
  }

  //Methode um Benutzer zu laden
  @Override
  public Benutzer[] ladeBenutzer() {

    try{

      FileInputStream fis = new FileInputStream(new File("./benutzer.xml"));
      XMLDecoder decoder = new XMLDecoder(fis);
      Benutzer tmp = new Benutzer();

      for (int i = 0; i < tmpRaum.length; i++){
        tmpBenutzer[i] = (Benutzer)decoder.readObject();
      }

      decoder.close();
      fis.close();

    }
    catch(IOException ex){
      ex.printStackTrace();
    }

    return tmpBenutzer;
  }

  //Methode um Buchungen zu laden
  @Override
  public Buchung[] ladeBuchung() {

    try{

      FileInputStream fis = new FileInputStream(new File("./buchung.xml"));
      XMLDecoder decoder = new XMLDecoder(fis);
      Buchung tmp = new Buchung();

      for (int i = 0; i < tmpBuchung.length; i++){
        tmpBuchung[i] = (Buchung)decoder.readObject();
      }

      decoder.close();
      fis.close();

    }
    catch(IOException ex){
      ex.printStackTrace();
    }

    return tmpBuchung;
  }

  //Methode um Räume zu laden
  @Override
  public Raum[] ladeRaum() {

    try{

      FileInputStream fis = new FileInputStream(new File("./raum.xml"));
      XMLDecoder decoder = new XMLDecoder(fis);
      Raum tmp = new Raum();

      for (int i = 0; i < tmpRaum.length; i++){
        tmpRaum[i] = (Raum)decoder.readObject();
      }

      decoder.close();
      fis.close();

    }
    catch(IOException ex){
      ex.printStackTrace();
    }

    return tmpRaum;
  }
}
