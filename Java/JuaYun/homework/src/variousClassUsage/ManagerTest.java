package variousClassUsage;

import java.util.ArrayList;
import java.util.List;

public class ManagerTest {
    static List<Member> memberList;
    static List<Product> productList;

    public ManagerTest() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }
    public static void addRandomProduct() {
        final String[] productNameArray = {"대출상품1", "대출상품2", "대출상품3"};
        for (int i = 0; i < productNameArray.length; i++) {
            productList.add(new Product(productNameArray[i]));
        }
    }
    public static void printProductList() {
        for (Product product: productList) {
            System.out.println(product);
        }
    }

    public void addRandomName() {
        // 문자열은 .length가 붙어야 한다.
        final String[] nameArray = {"김", "이", "박", "최", "우"};
        for (int i = 0; i < nameArray.length; i++) {
            memberList.add(new Member(nameArray[i]));
        }
    }
    public static void printRandomName() {
        for (Member member: memberList);
        System.out.println(memberList);
    }
}
