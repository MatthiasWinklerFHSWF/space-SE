package Domainmodell;

public class Benutzerart {

    private boolean student;
    private boolean admin;
    private boolean lehrender;
    private boolean stundenplanner;

    // Konstruktur - alle sind erstmal nichts
    public Benutzerart(){
        this.student = false;
        this.admin = false;
        this.lehrender = false;
        this.stundenplanner = false;
    }

    // get / set Methoden

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public void setLehrender(boolean lehrender) {
        this.lehrender = lehrender;
    }

    public void setStundenplanner(boolean stundenplanner) {
        this.stundenplanner = stundenplanner;
    }

    public boolean getStudent(){
        return student;
    }

    public boolean getAdmin(){
        return admin;
    }

    public boolean getLehrender(){
        return lehrender;
    }

    public boolean getStundenplanner(){
        return stundenplanner;
    }

    public String toString(){
        String  ausgabe = "";
        ausgabe = "Student " + student + "\n" +
                 "Admin " + admin + "\n" +
                 "Lehrender " + lehrender + "\n" +
                 "Stundenplanner " + stundenplanner;

        return ausgabe;
    }

    public void istAdmin(Benutzerart benutzerart){
       setAdmin(true);
    }

    public void istStudent(){
        setStudent(true);
    }

    public void istLehrender(){
        setLehrender(true);
    }

    public void istStundenplanner(){
        setStundenplanner(true);
    }


}
