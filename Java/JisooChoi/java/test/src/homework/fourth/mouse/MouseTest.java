package homework.fourth.mouse;

import java.util.Scanner;

public class MouseTest {
    public static void main(String[] args) {
        Mouse lgMouse = new Mouse("LG", false);
        lgMouse.mouseState();

        System.out.println();
        System.out.println("마우스 브랜드와 true, false 를 입력해주세요 > (enter)");
        Scanner scan = new Scanner(System.in);
        String mouseBrand = scan.nextLine();
        boolean mouseClick = scan.nextBoolean();

        Mouse samsungMouse = new Mouse(mouseBrand, mouseClick);
        samsungMouse.mouseState();
    }
}
