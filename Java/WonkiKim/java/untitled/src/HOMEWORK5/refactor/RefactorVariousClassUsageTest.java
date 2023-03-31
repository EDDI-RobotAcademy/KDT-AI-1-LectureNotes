package HOMEWORK5.refactor;


public class RefactorVariousClassUsageTest {
    public static void main(String[] args) {
        RefactorManager manager = new RefactorManager();

        for (int i=0; i <10; i++) {
            manager.addRandomMember();
        }
        manager.printMemberList();

        System.out.println();

        manager.addRandomProduct();
        manager.printProductList();
        System.out.println();
        manager.buyRandomProduct();
        manager.printProductList();
        System.out.println();
    }
}