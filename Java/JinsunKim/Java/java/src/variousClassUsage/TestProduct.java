package variousClassUsage;

public class TestProduct {
    final private String productName; //바꾸지 않을 정보
    final private String vendor; //바꾸지 않을 정보
    private int price; //객체가 두개일때 동일한 가격을 가진 상품이 두개가 된다. 그래서 final 안붙인다


    // 이런식으로 설정한다면, private TestMember member;
    // 상품을 구매할 때마다 사용자 정보가 매번 쌓임
    // 쓸데없는 정보 누적 -> 비용이 많이 들어감.
    //private TestMember member;
    final private int memberId; //memberid가 필요한 이유는 정보가 바뀌면 안되기 때문에


    public TestProduct(String productName, String vendor, int price, int memberId) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }


    public void changePrice(int price) { //setter , 가격을 바꿔야 해서 쓴거다.
        this.price = price;
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

    public void findMember(TestMember member) {
        System.out.println("상품 구매자를 찾습니다!");

        if (memberId == member.getMemberId()) {
            System.out.println(member);
            return;
        }
        System.out.println("구매자를 찾지 못하였습니다!");

    }
}
