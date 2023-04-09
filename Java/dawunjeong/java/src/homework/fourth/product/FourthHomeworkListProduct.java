package homework.fourth.product;

import variousClassUsage.extension.Manager;

public class FourthHomeworkListProduct {
    public static void main(String[] args) {
        HomeworkManager manager = new HomeworkManager();
        manager.addRandomMember();
        manager.printMemberList();
        System.out.println("");

        manager.addRandomProduct();
        manager.printProductList();
        System.out.println("");

        manager.buyRandomProduct();
        manager.printProductList();
    }
}