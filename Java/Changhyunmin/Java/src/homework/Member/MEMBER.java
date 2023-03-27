package homework.Member;

import java.util.Scanner;

public class MEMBER {
    public String Name = "장현민";
    public String Email;
    public String Password;
    public Scanner sc;
    public MEMBER() {
        sc = new Scanner(System.in);
    }
    public void inputEmail(){
        System.out.println("이메일을 작성해주세요.");
        Email = sc.nextLine();
    }
    public void inputPassword(){
        System.out.println("비밀번호를 작성해주세요.");
        Password = sc.nextLine();
    }
    @Override
    public String toString() {
        return Name + "이메일: " + Email + '\n' +
                "비밀번호: " + Password + '\n'+
                "방갑습니다." + Name + "님";
    }
}
