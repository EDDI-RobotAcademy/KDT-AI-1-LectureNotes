package variousClassUsage.refactor;

import java.util.ArrayList;
import java.util.List;

public class RefactorProduct {

    final private String productName;
    final private String vendor;
    private final int price;
    private List<Integer> memberIDList;

    public RefactorProduct(String productName, String vendor, int price){
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberIDList = new ArrayList<>();
    }

    public void setMemberID(int memberID) {
        memberIDList.add(memberID);
    }

    @Override
    public String toString() {
        return "RefactorProduct{" +
                "productName='" + productName + '\'' +
                ", vendor='" + vendor + '\'' +
                ", price=" + price +
                ", memberIDList=" + memberIDList +
                '}';
    }
}
