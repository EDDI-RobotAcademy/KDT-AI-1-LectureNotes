package variousClassUsageTest.extension;

public class ExtensionVariousClassUsageTest {
    // 일단 여러명의 회원을 배치합시다.
    // 또한 여러개의 상품을 배치합시다.
    // 랜덤을 사용해서 랜덤한 특정 상품을 랜덤한 회원이 구매하게 만듭니다.
    // 그리고 상품 구매자를 추적하도록 만드는 것이 이번 시나리오입니다.
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();
    }
}
