package customLibrary;

public class Register {
    final String ID;
    final String PW;
    final String name;
    //final String book;


    public String getID() {
        return ID;
    }

    public String getPW() {
        return PW;
    }

    public String getName() {
        return name;
    }

    public Register (String ID, String PW, String name) {
        this.ID = ID;
        this.PW = PW;
        this.name = name;
    }
}
