package homework.productProblem;

import utility.generator.SequenceGenerator;
import utility.random.CustomRandom;
import variousClassUsage.TestMember;
import variousClassUsage.TestProduct;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    List<TestMember> memberList;
    List<TestProduct> productList;

    public Manager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        for(int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            addMember();
        }


    }

    public void addMember () {
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;


            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }


            memberList.add(new TestMember(
                    SequenceGenerator.getCurrentSequenceMemberId(),
                    tmpString + "@test.com", "test"));



    }

    public void printMemberList () {
        for (TestMember member : memberList) {
            System.out.println(member);
        }
    }

    public void addRandomProduct() {
        final int MIN = 0;
        final int MAX = 2;

        final int DAECHUL_MIN = 1;
        final int DAECHUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3", };
        final String vendor = "DAECHWUL";

        for (int i = 0; i <productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHUL_MIN, DAECHUL_MAX);
            productList.add(new TestProduct(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList () {
        for (TestProduct product : productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            TestProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, MAX));
        }
    }
}
