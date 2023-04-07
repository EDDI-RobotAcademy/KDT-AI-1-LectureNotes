package problem.productProb2.product;

import java.util.ArrayList;
import java.util.List;

public class Product {

    final private String productName;
    final private String vendor;
    private int price;
    private List<Integer> memberIdList;

    public Product(String productName, String vendor, int price) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberIdList = new ArrayList<>();
    }

    public void setMemberId(int memberId) {
        memberIdList.add(memberId);
    }

    public List<Integer> getMemberIdList() {
        return memberIdList;
    }

    public String getProductName() {
        return productName;
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