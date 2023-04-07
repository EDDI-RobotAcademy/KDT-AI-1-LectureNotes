package variousClassUsageTest.extension;

import variousClassUsageTest.Manager;
import variousClassUsageTest.TestMember;
import java.util.List;

public class ExtensionVariousClassUsageTest {
    public static void main(String[] args) {
        //여러명의 회원을 배치합니다.
        //여러개의 상품을 배치합니다.
        //랜덤을 사용해서 랜덤한 특정 상품을 랜덤한 회원이 구매ㅏ게 만듭니다.
        //상품 구매자를 추적하도록 만드는 것이 이번 시나리오입니다.
        Manager manager = new Manager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();
    }

}
