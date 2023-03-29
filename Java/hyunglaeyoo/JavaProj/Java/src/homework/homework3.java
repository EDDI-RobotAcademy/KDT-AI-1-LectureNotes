package homework;

import java.util.Scanner;
class Member{
    private String Email;
    private String Pw;

    public String getEmail() {
        return Email;
    }

    public String getPw() {
        return Pw;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPw(String Pw) {
        this.Pw = Pw;
    }
}

public class homework3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Email을 입력하세요: ");

        System.out.println("Pw를 입력하세요: ");
    }
}
