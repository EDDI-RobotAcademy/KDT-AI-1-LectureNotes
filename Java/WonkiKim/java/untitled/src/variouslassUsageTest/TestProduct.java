package variouslassUsageTest;

public class TestProduct {
    final private String productName;
    final private String vendor;
    private int price;
    //상품을 구매할 때마다 사용자 정보가 매번 쌓임
    //private TestMember member;

    final private int memberId;


    public TestProduct(String productName, String vendor,int price, int memberId){
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }

    //setter를 사용할 땐 정말 필요한지 묻고 사용하기.
    public void changePrice(int price) {
        this.price = price;
    }
    public void findMember(TestMember member) {
        System.out.println("상품 구매자를 찾습니다.");
        if (member.getMemberId() == memberId) {
            System.out.println(member);
            return ;
        }
        System.out.println("구매자를 찾지 못했습니다!");
    }

    @Override
    public String toString() {
        return "TestProduct{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price + '\'' +
                ", memberId=" + memberId+

                '}';
    }
}
