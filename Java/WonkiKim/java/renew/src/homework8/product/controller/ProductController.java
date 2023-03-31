package homework8.product.controller;


import homework8.product.RefactorManager;
import homework8.product.RefactorProduct;
import utility.generator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));

        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();
        manager.buyRandomProduct();
        System.out.println();
        System.out.println("구매후");
        manager.printProductList();

        manager.addMember();
        manager.printMemberList();

        manager.printMemberListPurchaseProduct();
        System.out.println();

    }
}