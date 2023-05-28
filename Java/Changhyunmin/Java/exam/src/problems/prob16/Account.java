package problems.prob16;

public class Account {
    private int ID;
    private String AccountID;
    private String Password;

    public int getID() {
        return ID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public String getPassword() {
        return Password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", AccountID='" + AccountID + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
