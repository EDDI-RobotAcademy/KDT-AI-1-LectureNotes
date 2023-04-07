package variousClassUsageTest;


public class VariousClassUsageTest {

    public static void main(String[] args) {
        // 1. 클래스 사용하기
        // 2. 클래스간 정보 전달하기
        TestMember member = new TestMember(0,"test@test.com", "test");
        TestMember member2 = new TestMember(1,"test@test.com", "test");
        TestProduct product = new TestProduct("이거", "브랜드",5000, member.getMemberId());

        System.out.println("초기 상품 : " + product);

        //setter를 사용할 땐 정말 필요한지 묻고 사용하기
        product.changePrice(10000);
        System.out.println("상품정보갱신 : "+ product);

        product.findMember(member);
        product.findMember(member2);




    }
}
