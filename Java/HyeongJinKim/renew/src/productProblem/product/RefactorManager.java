package productProblem.product;

import productProblem.member.Customer;
import productProblem.member.Member;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.logging.Logger.global;

public class RefactorManager {
    List<Member> memberList;
    List<RefactorProduct> productList;
    Map<String, List<Integer>> buyInfoMap = new HashMap<>();

    public RefactorManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }

            memberList.add(new Member(
                    i, tmpString + "@test.com", "test"));
        }
    }

    public void printMemberList () {
        for (Member member: memberList) {
            System.out.println(member);
        }
    }
    public void addRandomProduct() {
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            productList.add(new RefactorProduct(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList () {
        for (RefactorProduct product: productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;

        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            int productNum = CustomRandom.generateNumber(0, productLength - 2);

            RefactorProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, MAX));

            buyInfoMap.put(productList.get(productNum).getProductName(), product.getMemberIdList());
        }
    }
//    public void printPurchaseMember(String customerName) {
//        if (productList.get(customerName) == null) {
//            System.out.println();
//        }
//        else {
//            System.out.println(productList.get(customerName);
//        }
//    }
}
