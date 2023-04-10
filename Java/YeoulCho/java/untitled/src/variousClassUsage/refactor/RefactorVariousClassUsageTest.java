package variousClassUsage.refactor;

import java.util.HashMap;
import java.util.Map;

//member가 한가지 제품만 구매할 수 있다
//여러 제품을 구매할 수 있는 경우로 바꿔라
public class RefactorVariousClassUsageTest {
    public static void main(String[] args) {
        RefactorManager manager =new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();
        System.out.println("----------------");
        manager.findProduct1Buyer(1); //원하는 대출상품번호를 넣으시오


}
}