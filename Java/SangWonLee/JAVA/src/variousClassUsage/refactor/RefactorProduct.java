package variousClassUsage.refactor;

import java.util.ArrayList;
import java.util.List;

public class RefactorProduct {

    final private String productName;
    final private String vendor;
    private String price;
    private List<Integer> memberIdList;

    public RefactorProduct(String productName, String vendor, String price) {
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