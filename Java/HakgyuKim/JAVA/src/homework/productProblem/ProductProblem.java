package homework.productProblem;

import utility.generator.SequenceGenerator;


public class ProductProblem {
    public static void main(String[] args) {

        // 추후 DB에서 보게될 AutoIcrement 방식의 id 증가 패턴과 동일함
        // System.out.println( SequenceGenerator.getCurrentSequenceMemberId());
        // System.out.println( SequenceGenerator.getCurrentSequenceMemberId());
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
