package variousClassUsage;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        // 1. 그냥 클래스 사용하기
        /*
        TestProduct product = new TestProduct(
                "이거", "저거브랜드", 5000);
        System.out.println("초기 상품: " + product);
        // setter를 사용할 땐 정말 필요한지 묻고 사용하기!
        product.changePrice(10000);
        System.out.println("상품 정보 갱신: " + product); */

        // 2. 클래스간 정보 전달하기
        TestMember member = new TestMember(
                0, "test@test.com", "test");
        TestMember member2 = new TestMember(
                1, "gogo@test.com", "test");

        TestProduct product = new TestProduct(
                "이거", "저거브랜드",
                5000, member.getMemberId());

        System.out.println("상품 구매 정보: " + product);

        product.findMember(member);
        product.findMember(member2);
    }
}