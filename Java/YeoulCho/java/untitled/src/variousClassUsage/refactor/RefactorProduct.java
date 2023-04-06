package variousClassUsage.refactor;

import java.util.ArrayList;
import java.util.List;

public class RefactorProduct {
    final private String productName;
    final private String vendor;
    private int price;

    private List<Integer> memberIdList; // memberIdList는 Integer의 리스트


    public RefactorProduct(String productName, String vendor, int price) {
        this.productName = productName;
        this.vendor = vendor;
        this.price = price;
        this.memberIdList = new ArrayList<>(); //product에 구매한사람의 리스트를 가지고 있겠다.
    }

    public void setMemberIdList(int memberId) {
        memberIdList.add(memberId); //memberIdList에 memberId를 추가하겠다.
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
