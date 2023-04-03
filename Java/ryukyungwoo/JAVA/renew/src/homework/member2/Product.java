package homework.member2;

import java.awt.*;
import java.util.ArrayList;

public class Product {
    final private String productName;
    final private String vendor;
    private int price;
    private List<Integer> memberIdList;
    public Product (String productName, String vendor, int price) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberIdList = new ArrayList<>();
    }
    public void setMemberId(int memberId) {
        memberIdList.add(memberId);
    }
    public String getProductName() {
        return productName;
    }
    public List<Integer> getMemberIdList() {
        return memberIdList;
    }
}