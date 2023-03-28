package variousClassUsage;

public class TestProduct {

    final private String productName;
    final private String vendor;
    private int price; // final이 안되는 이유: 객체가 두개 되니까

    // private TestMember member; // 프로덕트에 멤버 걸려있으면? 누가 구매했다를 알 수 있음
    // 그러나 여기에 문제점
    // 상품을 구매할 때마다 사용자 정보가 매번 쌓임
    // 쓸데없는 정보들이 계속 누적
    // 이렇게 하면 안되는 이유는? (서비스 회사들의 면접질문)
    // 데이터가 뭉쳐서 나가면 돈이 커짐

    private int memberId;
    // 그래서 이게 필요
    // 정보 변경하지 못하게 하기 위해 final

    public TestProduct(String productName, String vendor, int price, int memberId) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }

    public TestProduct(String productName, String vendor, int price) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberId = -1; // 이 상품을 구매한 회원이 없을 때 뜨도록
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void changePrice (int price) { // 이것도 setter
        this.price = price;
    }

    public void findMember(TestMember member) { // 클래스도 파라미터로 넘길 수 있구나
        System.out.println("상품 구매자를 찾습니다!");

        if (memberId == member.getMemberId()) {
            System.out.println(member);
            return;
        }

        System.out.println("구매자를 찾지 못하였습니다!");
    }

    @Override
    public String toString() {
        return "TestProduct{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberId=" + memberId +
                '}';
    }
}
