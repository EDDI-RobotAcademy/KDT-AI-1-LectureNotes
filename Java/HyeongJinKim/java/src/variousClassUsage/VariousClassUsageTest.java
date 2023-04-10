package variousClassUsage;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        /*TestProduct product = new TestProduct(
                "이거", "저거브랜드", 5000);
        // setter를 사용할 때는 정말 필요한 지 물어보고 사용하기
        System.out.println("초기 상품: " + product);

        product.changePrice(10000);

        System.out.println("상품 정보 갱신: " + product);*/
        TestMember member = new TestMember(
                0, "tess@test.com", "test");
        TestMember member2 = new TestMember(
                0, "tess@test.com", "test");
        TestProduct product = new TestProduct(
                "이거", "저거브랜드", 5000, member.getMemberId());

        System.out.println("상품 구매 정보: " + product);

        product.findMember(member);
        product.findMember(member2);
    }
}
