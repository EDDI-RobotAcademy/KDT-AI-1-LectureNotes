package homework.third.signup;

import java.util.Scanner;

public class Email{
    String email = "";

    public Email(){
    }

    public void getEmail() {
        System.out.print("이메일: ");
        Scanner scanEmail = new Scanner(System.in);

        this.email = scanEmail.nextLine();
    }
}
