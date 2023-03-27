package variousClassUsage.extension;

public class ExtensionVariousClassUsageTest {
    public static void main(String[] args) {
        // 일단 여러명의 회원과 여러개의 상품을 배치
        // 랜덤을 사용해 랜덤한 상품을 랜덤한 회원이 구매
        // 상품 구매자를 추적해보자.
        Manager manager = new Manager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();
    }
}
