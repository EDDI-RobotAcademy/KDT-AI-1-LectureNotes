package variousClassUsage;

public class TestProduct {

    final private String productName;
    final private String vendor;
    private int price;

    // 상품을 구매할 때마다 사용자 정보가 매번 쌓임
    //private TestMember member;
    final private int memberId;

    public TestProduct(String productName, String vendor, int price, int memberId) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }

    public void changePrice(int price) {
        this.price = price;
    }
    public void findMember(TestMember member) {
        System.out.println("상품 구매자를 찾습니다!");

        if (memberId == member.getMemberId()) {
            System.out.println(member);
            return;
        }
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
