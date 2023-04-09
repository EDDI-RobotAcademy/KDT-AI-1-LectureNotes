package variouslassUsageTest;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        TestMember member = new TestMember("test@email.com","testpasswor" , 0);
        TestMember member2 = new TestMember("test2@email.com", "test2password", 1);
        // 1. 그냥 클래스 사용하기
        TestProduct product = new TestProduct("이거", "저브랜드", 5000, member.getMemberId());
        System.out.println("초기상품: " + product);

        product.changePrice(10000);

        System.out.println("상품정보갱신: " + product);

        product.findMember(member);
        product.findMember(member2);

        // 2. 클래스간 정보 전달하기



    }
}
