package variousClassUsage.refactor;

import variousClassUsage.extension.Manager;

public class ReFactorVariousClassUsageTest {
    public static void main(String[] args) {
        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();

        manager.buyRandomProduct();
        manager.printProductList();
    }
}
