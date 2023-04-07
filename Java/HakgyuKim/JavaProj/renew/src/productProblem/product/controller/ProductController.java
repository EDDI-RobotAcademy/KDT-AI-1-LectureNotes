package productProblem.product.controller;


import productProblem.product.Manager;
import utility.generator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {

        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));

        Manager manager = new Manager();
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