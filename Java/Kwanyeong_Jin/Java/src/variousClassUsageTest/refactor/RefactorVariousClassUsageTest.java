package variousClassUsageTest.refactor;

import variousClassUsageTest.Manager;

public class RefactorVariousClassUsageTest {
        public static void main(String[] args) {
            RefactorManager refactorManager = new RefactorManager();
            refactorManager.addRandomMember();
            refactorManager.printMemberList();

            refactorManager.addRandomProduct();
            refactorManager.printProductList();

            refactorManager.buyRandomProduct();
            refactorManager.printProductList();
        }
}
