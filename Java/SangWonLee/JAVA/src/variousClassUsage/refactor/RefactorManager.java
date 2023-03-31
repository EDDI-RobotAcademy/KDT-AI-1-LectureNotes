package variousClassUsage.refactor;

import variousClassUsage.Custom_Random;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RefactorManager {
    List<RefactorMember> memberList;
    List<RefactorProduct> productList;

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
            int emailLength = Custom_Random.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) Custom_Random.generateNumber('a', 'z');
            }

            memberList.add(new RefactorMember(
                    i, tmpString + "@test.com", "test"));
        }
    }

    public void printMemberList () {
        for (RefactorMember member: memberList) {
            System.out.println(member);
        }
    }

    public void addRandomProduct() {
        DecimalFormat df = new DecimalFormat("###,### ");
        final int DAECHWUL_MIN = 100;
        final int DAECHWUL_MAX = 10000;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000 * Custom_Random.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            String dfPrice = df.format(price);
            productList.add(new RefactorProduct(
                    productNameArray[i], vendor, dfPrice));
        }
    }

    public void printProductList () {
        for (RefactorProduct product: productList) {
            System.out.println(product);

        }
        System.out.println();
    }



    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;

        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            RefactorProduct product = productList.get(
                    Custom_Random.generateNumber(2));

            product.setMemberId(
                    Custom_Random.generateNumber(MIN, MAX));
        }
    }
}