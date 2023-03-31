package problem.productProb2.product.controller;


import problem.productProb2.product.Manager;
import utility.generator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {

        Manager manager = new Manager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();

        manager.getProductBuyerId("대출상품1");
        manager.getProductBuyerFullInfo("대출상품1");
    }
}