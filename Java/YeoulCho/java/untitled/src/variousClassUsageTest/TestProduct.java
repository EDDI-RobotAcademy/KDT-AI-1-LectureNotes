package variousClassUsageTest;

public class TestProduct {

    final private String productName;
    final private String Vendor;
    private int price;

    // 상품을 구매할 때마다 사용자 정보가 매번 쌓임
    // 왜 이렇게 하면 안될까? 돈이 많이 듬
    //private  TestMember member; //누가 구했는지 알 수 있음

    final private int memberId;


    public TestProduct(String productName, String vendor, int price, int memberId) {
        this.productName = productName;
        Vendor = vendor;
        this.price = price;
        this.memberId = memberId;
    }



    public void changePrice(int price) {
        this.price = price; // setter, 정말 가격을 바꿔야하니 사용
    }

    public void findMember(TestMember member){
        System.out.println("상품구매자 찾습니다.");

        if(memberId == member.getMemberId()){
            System.out.println(member);
            return;

        }
        System.out.println("구매자를 찾지 못했습니다.");
    }

    @Override
    public String toString() {
        return "TestProduct{" +
                "productName='" + productName + '\'' +
                ", Vendor='" + Vendor + '\'' +
                ", price=" + price +
                ", memberId=" + memberId +
                '}';
    }
}

