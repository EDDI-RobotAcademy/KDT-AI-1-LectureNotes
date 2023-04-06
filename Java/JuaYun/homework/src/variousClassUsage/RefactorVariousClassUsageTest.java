package variousClassUsage;

public class RefactorVariousClassUsageTest {
    public static void main(String[] args) {
        ManagerTest managerTest = new ManagerTest();
        System.out.println();

        ManagerTest.addRandomProduct();
        ManagerTest.printProductList();

        managerTest.addRandomName();
        managerTest.printRandomName();

    }
}
