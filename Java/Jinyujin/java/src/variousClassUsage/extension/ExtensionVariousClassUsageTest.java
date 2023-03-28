package variousClassUsage.extension;

import variousClassUsage.TestMember;
import variousClassUsage.TestProduct;

import java.util.ArrayList;
import java.util.List;

// 여기 코드의 흐름을 쭉 따라가볼 것!!!

public class ExtensionVariousClassUsageTest {
    public static void main(String[] args) {
        // 리스트도 관리할 것

        // 나는 회원들을 여러명 만들어서 정보를 프로덕트구매자로 놓을 것입니다
        // 거기서 다시 프로덕트를 통해서 구매자를 찾겠다
        // 일단 여러명의 회원을 배치합시다.
        // 또한 여러개의 상품을 배치합시다.
        // 랜덤을 사용해서 랜덤한 특정 상품을 랜덤한 회원이 구매하게 만듭니다.
        // 그리고 상품 구매자를 추적하도록 만드는 것이 이번 시나리오입니다.
        // 이런 시나리오가 외부로 가는 것이 서비스

        Manager manager = new Manager();
        manager.addRandomMember(); // 랜덤을 사용해서 랜덤한 특정 상품을 랜덤한 회원이 구매하게 만듭니다. -> 회원들 만들어야 해서
        manager.printMemberList();

        // 사용자 정보 만들었으니 상품도!
        manager.addRandomProduct();
        manager.printProductList();

        // memberId 부여해야댐
        manager.buyRandomProduct();
        manager.printProductList();
    }
}
