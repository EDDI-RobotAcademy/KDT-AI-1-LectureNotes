package question;

import java.util.Scanner;

class Mouse {
    Scanner sc = new Scanner(System.in);
    public boolean MouseTouch;
    private String BrandName;

    public Mouse() {
        if (MouseTouch == false){
            System.out.println("마우스가 눌렸습니다.");
        }else {
            System.out.println("마우스가 눌리지 않았습니다.");
        }
        System.out.print("마우스 브랜드 이름: ");
        BrandName = sc.nextLine();
    }

    @Override
    public String toString() {
        return "마우스 브랜드 이름: " + BrandName;
    }
}
public class Question_4 {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.MouseTouch = true;
        System.out.println(mouse);
    }
}
