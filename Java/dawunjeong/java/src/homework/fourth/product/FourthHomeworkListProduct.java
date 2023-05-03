package homework.fourth.product;

import variousClassUsage.extension.Manager;

public class FourthHomeworkListProduct {
    public static void main(String[] args) {
        HomeworkManager manager = new HomeworkManager();
        manager.addRandomMember(); // 랜덤한 멤버를 생성
        manager.printMemberList(); // 랜덤한 멤버 리스트를 출력
        System.out.println("");

        manager.addRandomProduct(); // 랜덤 상품을 생성
        manager.printProductList(); // 랜덤 상품을 출력
        System.out.println("");

        manager.buyRandomProduct();
        manager.printProductList();
    }
}