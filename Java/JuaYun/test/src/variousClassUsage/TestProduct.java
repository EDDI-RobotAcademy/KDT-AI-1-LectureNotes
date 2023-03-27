package variousClassUsage;

public class TestProduct {

    final private String productName;
    final private String vendor;
    private int price; // 가격은 바뀔 수 있기 때문에 final처리를 하지않음.

    // 상품을 구매할 때마다 사용자 정보가 매번 쌓임
    // private TestMember member;
    private int memberId;

    // 생성자
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
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public void findMember(TestMember member) {
       System.out.println("상품 구매자를 찾습니다.");

        // memberId는 현재 객체 자신이 가지고 있는 숫자입니다.
        // member.getMemberId()는 외부에서 입력되어 들어온
        // member가 가지고 있는 memberId 값입니다.
       if (memberId == member.getMemberId()) {
           System.out.println(member);
           return;
       }

       System.out.println("구매자를 찾지 못하였습니다.");
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
