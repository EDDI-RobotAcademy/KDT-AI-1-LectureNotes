package homework.fifth.refactor.productReview;

public class HomeworkVariousClassUsageTest {
    public static void main(String[] args) {
        HomeworkManager manager = new HomeworkManager();

        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();

        manager.addMember();
        manager.printMemberList();
    }
}
