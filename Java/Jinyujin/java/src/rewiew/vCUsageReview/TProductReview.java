package rewiew.vCUsageReview;

public class TProductReview {

    final private String productName;
    final private String vendor;
    private int price;

    // 상품을 구매할 때마다 사용자 정보가 매번 쌓임
    final private int memberId; // 그것을 구별해 주기 위함

    public TProductReview(String productName, String vendor, int price, int memberId) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public void findMember (TMemberReview member) {
        System.out.println("상품 구매자를 찾습니다!");

        if (memberId == member.getMemberId()) {
            System.out.println(member);
            return;
        }
        System.out.println("구매자를 찾지 못하였습니다!");
    }

    @Override
    public String toString() {
        return "TProductReview{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberId=" + memberId +
                '}';
    }
}
