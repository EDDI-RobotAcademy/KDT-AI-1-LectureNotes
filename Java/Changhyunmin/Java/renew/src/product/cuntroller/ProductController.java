package product.cuntroller;

import utility.genrtator.SequenceGenerator;

public class ProductController {
    public static void main(String[] args) {
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));
        System.out.println(SequenceGenerator.getSpecificEntityId("Entity"));

        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        //1랜덤
        manager.printMemberList();
        //프린트
        manager.addRandomProduct();
        //2
        manager.printMemberList();
        //프린트
        manager.buyRandomProduct();
        //3
        manager.printMemberList();
        //프린트
        manager.addMember();
        //4
        manager.printMemberList();
        //프린트
    }
}
