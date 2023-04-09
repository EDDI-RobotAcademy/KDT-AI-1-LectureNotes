package variousClassUsage.refactor;

import utility.generator.SequenceGenerator;
import variousClassUsage.extension.Manager;

public class RefactorVariousClassUsageTest {
    public static void main(String[] args) {

//        System.out.println(SequenceGenerator.getCurrentSequenceMemberId());
//        System.out.println(SequenceGenerator.getCurrentSequenceMemberId());

        RefactorManager manager = new RefactorManager();
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