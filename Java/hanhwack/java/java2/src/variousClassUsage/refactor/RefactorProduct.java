package variousClassUsage.refactor;

import java.util.ArrayList;
import java.util.List;

public class RefactorProduct {

    final private String productName;
    final private String vendor;
    private int price;
    //상품을 구매할 때마다 사용자 정보가 매번 쌓임
    //private TestMember member;
    private List<Integer> memberIdList;


    public RefactorProduct(String productName, String vendor, int price) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberIdList = new ArrayList<>();
    }




    public void setMemberId(int memberId) {
        memberIdList.add(memberId);
    }

    @Override
    public String toString() {
        return "RefactorProduct{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberIdList=" + memberIdList +
                '}';
    }
}
