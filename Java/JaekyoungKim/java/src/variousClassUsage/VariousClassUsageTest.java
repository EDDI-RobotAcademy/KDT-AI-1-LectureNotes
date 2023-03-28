package variousClassUsage;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        /*TestProduct product= new TestProduct(
                "이거","저거브랜드",4050
        );
        System.out.println("초기 상품 정보: "+product);
        //setter를 사용할땐 정말 필요한지 묻고 사용하기!
        product.changePrice(10000);
        System.out.println("상품 정보 갱신: "+product);*/
        TestMember member =new TestMember(0,"test@test.com","test");
        TestMember member2 =new TestMember(1,"test@test.com","test");
        TestProduct product= new TestProduct("이거","저거",4500,member.getMemberId());
        System.out.println("상품 구매 정보: "+product);

        product.findMember(member);
        product.findMember(member2);




    }
}
// 클래스 간의 정보 전달
