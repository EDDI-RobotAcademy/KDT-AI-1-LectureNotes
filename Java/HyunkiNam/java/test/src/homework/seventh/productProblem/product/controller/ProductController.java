package homework.seventh.productProblem.product.controller;

import homework.seventh.productProblem.product.ProductManager;

public class ProductController {
    public static void main(String[] args) {

        ProductManager manager = new ProductManager();

        manager.createRandomProduct();
        manager.printProduct();

        manager.createRandomMember();
        manager.printMember();

        manager.buyRandomProduct();
        manager.searchBuyer();

        manager.searchBuyerInfo("S20");
        System.out.println("--------------------------");
        manager.searchBuyerInfo("S21");
        System.out.println("--------------------------");
        manager.searchBuyerInfo("S22");
    }
}