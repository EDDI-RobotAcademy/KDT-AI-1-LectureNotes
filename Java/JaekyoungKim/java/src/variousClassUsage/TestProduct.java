package variousClassUsage;

public class TestProduct {
    final private String productNAme;
    final private String vendor;

    public void changePrice(int price) {
        this.price = price;
    }
    public void findMember(TestMember member){
        System.out.println("상품 구매자를 찾습니다!");
        if(memberId==member.getMemberId()){
            System.out.println(member);
            return;
        }
        System.out.println("구매자를 찾지 못하였습니다.");
    }

    private int price;
    // 상품을 구매할 때마다 사요앚 정보가 매번 쌓임
    //private  TestMember Member;
    final private int memberId;

    public TestProduct(String productNAme, String vendor, int price, int memberId) {
        this.productNAme = productNAme;
        this.vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "TestProduct{" +
                "productNAme='" + productNAme + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberId=" + memberId +
                '}';
    }
}
