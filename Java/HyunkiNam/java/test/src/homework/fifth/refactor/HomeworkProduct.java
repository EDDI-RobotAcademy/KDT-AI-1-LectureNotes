package homework.fifth.refactor;

import java.util.ArrayList;
import java.util.List;

public class HomeworkProduct {

    final private String productName;
    final private String vendor;
    private int price;
    private List<Integer> memberIDList;

    public HomeworkProduct(String productName, String vendor, int price){
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
