package ztest;

public class VariousClassUsageTest {
    public static void main(String[] args) {
        TestMember member = new TestMember(0, "jinho1593@naver.com","123123");
        TestMember member2 = new TestMember(1, "Kim3252@naver.com","0988766");

        TestProduct product = new TestProduct("햄버거","맘스터치",4500, member.getMemberId());

        System.out.println("상품 구매 정보" + product);

        product.findMember(member);
        product.findMember(member2);
    }
}
