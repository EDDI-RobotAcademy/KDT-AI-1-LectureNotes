package variousClassUsage.refactor;

import variousClassUsage.extension.Manager;


public class RefactorExtensionVariousClassUsageTest {
    //일단 여러명의 회원을 배치합시다.
    // 또한 여러개의 상품을 배치합니다.
    // 랜덤을 사용해서 랜덤한 특정 상품을 회원이 구매하게 만듭니다.
    // 그리고 상품 구매자를 추적하도록 만드는 것이 이번 시나리오 입니다.
    public static void main(String[] args) {
       variousClassUsage.extension.Manager manager =new Manager();
       manager.addRandomMember();
       manager.printMemberList();
       manager.addRandomProduct();
       manager.printProductList();

       manager.buyRandomProduct();
       manager.printProductList();
    }
}
