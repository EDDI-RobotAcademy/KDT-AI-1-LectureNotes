package variousClassUsageTest.refactor;


import java.util.ArrayList;
import java.util.List;

public class RefactorTestProduct {

    final private String productName;
    final private String vendor;
    private int price;
    // 상품 구매할 때마다 사용자 정보가 매번 쌓임
//    private TestMember member;
    private List<Integer> memberIdList;


    public RefactorTestProduct(String productName, String vendor, int price){
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberIdList = new ArrayList<>();
    }

    public void changePrice(int price){
        this.price = price;
    }

    public List getMemberId() {
        return memberIdList;
    }

    public void setMemberId(int memberId){
        memberIdList.add(memberId);
    }

    @Override
    public String toString() {
        return "TestProduct{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberId=" + memberIdList +
                '}';
    }
}
