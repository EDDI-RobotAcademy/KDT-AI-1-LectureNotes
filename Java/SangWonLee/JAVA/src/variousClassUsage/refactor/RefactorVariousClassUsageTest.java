package variousClassUsage.refactor;

public class RefactorVariousClassUsageTest {
    public static void main(String[] args) {
        RefactorManager manager = new RefactorManager();

        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();


    }
}