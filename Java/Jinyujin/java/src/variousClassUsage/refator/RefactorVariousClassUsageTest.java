package variousClassUsage.refator;

import variousClassUsage.extension.Manager;

public class RefactorVariousClassUsageTest {
    public static void main(String[] args) {
        RefactorManager manager = new RefactorManager();
        manager.addRandomMember();
        manager.printMemberList();

        manager.addRandomProduct();
        manager.printProductList();

        manager.buyRandomProduct();
        manager.printProductList();
    }
// 이제 여러 사용자가 동일 상품 대출한 것도 확인 가능

    // 이 흐름을 쭉 따라가 볼 것
}
