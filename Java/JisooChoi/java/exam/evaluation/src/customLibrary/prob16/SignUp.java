package customLibrary.prob16;

import java.util.Scanner;

public class SignUp {
    private String name;
    private int age;
    private String address;

    public SignUp() {
        WritingOutPersonalInformation();
    }

    public void WritingOutPersonalInformation(){
        Scanner scan = new Scanner(System.in);
        System.out.printf("이름을 입력해주세요 : ");
        this.name = scan.nextLine();
        System.out.printf("나이를 입력해주세요 : ");
        this.age = scan.nextInt();
        scan.nextLine();
        System.out.printf("주소를 입력해주세요 : ");
        this.address = scan.nextLine();

        checkInfo(name);
    }

    public void checkInfo(String name){
        System.out.println(this.name+"님의 회원가입이 완료되었습니다!");
    }


}
