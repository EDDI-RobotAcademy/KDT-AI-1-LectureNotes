package homework8.product.controller;


import homework8.product.RefactorManager;
import homework8.product.RefactorProduct;
import utility.generator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {
        final int NUMBER_OF_MEMBER = 5;

        RefactorManager manager = new RefactorManager();
        manager.addManyMember(NUMBER_OF_MEMBER);
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();
        manager.buyRandomProduct();

        System.out.println();
        System.out.println("구매후");

        manager.printProductList();

        manager.printMemberListPurchaseProduct();
        System.out.println();

    }
}