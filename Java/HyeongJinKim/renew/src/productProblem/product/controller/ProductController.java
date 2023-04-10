package productProblem.product.controller;

import productProblem.product.RefactorManager;
import productProblem.product.RefactorProduct;
import utility.generator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {
        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();

//        manager.printPurchaseMember("");
    }
}