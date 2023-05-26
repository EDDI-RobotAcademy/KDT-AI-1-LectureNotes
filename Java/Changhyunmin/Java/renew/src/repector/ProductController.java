package repector;

import java.util.function.Predicate;
import java.util.stream.Stream;


public class ProductController {

    public static void main(String[] args) {
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
