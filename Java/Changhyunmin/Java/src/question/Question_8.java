package question;

import java.util.InputMismatchException;
import java.util.Scanner;

class Friend{
    String Name;
    String PhoneNum;

    public Friend(String name, String phoneNum) {
        this.Name = name;
        this.PhoneNum = phoneNum;
    }
    public void ShowPhoneNum() {
        System.out.println(Name + "의 번호는" + PhoneNum + "입니다.");
    }
}

public class Question_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        do{
            try{
                System.out.println("인원 수 입력: ");
                int personNum = sc.nextInt();
                Friend[] p = new Friend[personNum];
                for (int i = 0; i < p.length; i++) {
                    System.out.println("이름: ");
                    String pName = sc.next();
                    System.out.println("전화번호: ");
                    String pNum = sc.next();
                    p[i] = new Friend(pName , pNum);
                }
                System.out.println("저장되었습니다.");

                for(int j = 0; j < Integer.MAX_VALUE; j++) {
                    System.out.println("검색할 이름: ");
                    String searchName = sc.next();

                    boolean test = true;

                    for (int i = 0; i < p.length; i++) {
                        if (searchName.equals(p[i].Name)) {
                            p[i].ShowPhoneNum();
                            test = true;
                            break;
                        }else {
                            test = false;
                        }
                    }
                    if (searchName.equals("그만")) {
                        System.out.println("프로그램을 종료합니다.");
                        exit = true;
                        break;
                    }
                    else if (!test) {
                        System.out.println(searchName + "은(는) 존재하지 않습니다.");
                    }
                }
                sc.close();
            }catch (InputMismatchException e) {
                System.out.println("값을 제대로 입력해주세요.");
            }
        }while (!exit);
    }
}
