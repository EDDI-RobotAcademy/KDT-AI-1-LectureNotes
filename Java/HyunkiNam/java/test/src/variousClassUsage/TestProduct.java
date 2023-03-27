package variousClassUsage;

public class TestProduct {

    final private String productName;
    final private String vendor;
    private int price;

    // 상품을 구매할 때마다 구매자 정보가 쌓임
    // 이대로 진행시 비용 터짐
    // private TestMember member;

    private int memberID;

    public TestProduct(String productName, String vendor, int price, int memberID){
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberID = memberID;
    }

    public TestProduct(String productName, String vendor, int price) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberID = -1;
    }

    public void changePrice(int price) {
        this.price = price;
    }

    public void findMember(TestMember member) {
        System.out.println("상품 구매자 정보 조회");
        if(memberID == member.getmemberID()){
            System.out.println(member);
            return;
        }
        System.out.println("정보 찾을 수 없음");
    }

    @Override
    public String toString() {
        return "TestProduct{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberID=" + memberID +
                '}';
    }


    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }
}
