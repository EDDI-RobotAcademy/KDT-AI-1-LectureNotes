package variousClassUsage;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        // 1. 그냥 클래스 사용하기
        /*
        TestProduct product = new TestProduct("이거", "저거브랜드", 5000);

        System.out.println("초기 상품: " + product);

        // setter를 사용할 땐 정말 필요한지 묻고 사용하기
        // - 아직 판단하긴 힘듬 그러니 일단 써도 상관없음
        product.changePrice(10000); //이걸 만들고 나니까 없는 것 -> 만들어줘야 하는 것

        System.out.println("상품 정보 갱신: " + product); */

        // -> 가격만 변화한걸 잘 확인할 수 있음

        // 2. 클래스간 정보 전달하기
        // 누가 이 상품을 샀냐? 관리했냐? 의 사용자 정보가 필요할 것 같아 보임
        TestMember member = new TestMember(
                0, "test@test.com", "test");
        TestMember member2 = new TestMember(
                1, "gogo@test.com", "test");
        // 0번은 실제 구매자, 1번은 구매하지 않음

        TestProduct product = new TestProduct(
                "이거", "저거브랜드",
                5000, member.getMemberId());

        // setter를 사용할 땐 정말 필요한지 묻고 사용하기
        // - 아직 판단하긴 힘듬 그러니 일단 써도 상관없음
        product.changePrice(10000); //이걸 만들고 나니까 없는 것 -> 만들어줘야 하는 것

        System.out.println("상품 구매 정보: " + product);

        product.findMember(member); // 상품 정보가 나올건데 상품 구매한 사용자 찾고싶다는 생각을 한 관점
        // 빨간 줄 나오니까 자동으로 나오는 메소드 생성 클릭
        product.findMember(member2);

    }
}
