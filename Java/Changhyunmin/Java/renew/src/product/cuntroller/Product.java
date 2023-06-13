package product.cuntroller;

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

    @Override
    public String toString() {
        return "상품이름: " + productName + ", vendor: " + vendor +
                "가격: " + price +
                "맴버Id: " + memberIdList;
    }
}
