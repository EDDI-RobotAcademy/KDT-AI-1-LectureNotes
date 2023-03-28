package variousClassUsage.extension;

public class ExtensionVariousClassUsageTest {

    // 일단 여러명의 회원을 배치합시다. -> 리스트 만들어둠
    // 또한 여러 개의 상품을 배치합시다. -> 리스트 만들어둠
    // 랜덤을 사용해서 랜덤한 특정 상품을 랜덤한 회원이 구매하게 만듭니다. ->randomMember 만듬(아래)
    // 그리고 상품 구매자를 추적하도록 만드는 것이 이번 시나리오입니다.
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addRandomMember();
        manager.printMemberList();

        System.out.println();

        manager.addRandomProduct();
        manager.printProductList();
//
//        System.out.println();
//
//        manager.buyRandomProduct();
//        manager.printProductList();
    }
}
