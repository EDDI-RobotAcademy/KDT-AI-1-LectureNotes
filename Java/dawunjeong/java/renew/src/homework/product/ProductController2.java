package homework.product;


public class ProductController2 {
    public static void main(String[] args) {
        RefactorManager2 manager = new RefactorManager2();
        manager.addRandomMember();
        manager.printMemberList();
        System.out.println();

        manager.addRandomProduct();
        manager.printProductList();
        System.out.println();

        manager.buyRandomProduct();
        manager.printProductList();

        manager.fineProductMember();

    }
}