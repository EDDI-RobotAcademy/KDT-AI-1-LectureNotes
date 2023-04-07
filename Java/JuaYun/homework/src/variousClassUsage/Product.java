package variousClassUsage;

import java.util.ArrayList;
import java.util.List;

public class Product {
    final private String productName;
    public List<Integer> memberIdList;

    public Product(String productName) {
        this.productName = productName;
        this.memberIdList = new ArrayList<>();
    }
    public void setMemberId(int memberId){
        memberIdList.add(memberId);
    }

    public Product(String productName, List<Integer> memberIdList) {
        this.productName = productName;
        this.memberIdList = memberIdList;
    }

    @Override
    public String toString() {
        return "productName='" + productName + '\'' +
                ", memberIdList=" + memberIdList;
    }
}
