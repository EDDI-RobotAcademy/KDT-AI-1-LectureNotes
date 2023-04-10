package homework.fifth.refactor;

import utility.random.CustomRandom;

public class HomeworkVariousClassUsageTest {
    public static void main(String[] args) {
        HomeworkManager manager = new HomeworkManager();
        manager.addRandomMember(CustomRandom.generateNumber(1,10));
        manager.addRandomMember(5);
        manager.addRandomMember(8);
        manager.printMemberList();

//        manager.addRandomProduct();
//
//        manager.buyRandomProduct();
//        manager.printProductList();
    }
}
