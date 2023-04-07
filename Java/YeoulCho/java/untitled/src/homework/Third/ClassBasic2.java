package homework.Third;

import java.util.Scanner;

class Member{
    private String member_Name;
    private String member_Mail;
    private String member_Code;


    public Member(String member_Name, String member_Mail, String member_Code) {
        this.member_Name = member_Name;
        this.member_Mail = member_Mail;
        this.member_Code = member_Code;
    }

    public String getMember_Name() {
        Scanner scan = new Scanner(System.in);
        System.out.println("회원의 이름을 입력해주세요");
        String member_Name = scan.nextLine();
        return member_Name;
    }

//    public void setMember_Name(String member_Name) {
//        this.member_Name = member_Name;
//    }
//
//    public void setMember_Mail(String member_Mail) {
//        this.member_Mail = member_Mail;
//    }
//
//    public void setMember_Code(String member_Code) {
//        this.member_Code = member_Code;
//    }

    public String getMember_Mail() {
        Scanner scan = new Scanner(System.in);
        System.out.println("회원의 메일을 입력해주세요");
        String member_Mail = scan.nextLine();
        return member_Mail;
    }

    public String getMember_code() {
        Scanner scan = new Scanner(System.in);
        System.out.println("회원의 비밀번호를 입력해주세요");
        String member_Code = scan.nextLine();
        return member_Code;
    }
}

public class ClassBasic2 {

    public static void main(String[] args) {

        Member member1 = new Member("","","");
        String member_Name= member1.getMember_Name();
        String member_Mail= member1.getMember_Mail();
        String member_Code= member1.getMember_code();



        System.out.println(member_Name +"님의 이메일 주소는: "+member_Mail +", \n"+
                    "비밀번호는: "+member_Code +"입니다.");

    }
}
