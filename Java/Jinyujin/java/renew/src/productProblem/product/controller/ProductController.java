package productProblem.product.controller;

import productProblem.product.RefactorManager;
import utility.generator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));

        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();
    }
}
