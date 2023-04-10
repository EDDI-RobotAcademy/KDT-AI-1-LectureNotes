package variousClassUsage.extension;

import test.Test.Test;
import utility.CustomRandom;
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
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;


        for(int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MAX_EMAIL_LENGTH,MIN_EMAIL_LENGTH);
            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }

            memberList.add(new TestMember(i, tmpString + "@test.com", "test"));
        }

    }

    //ExtensionVariousClassUsageTest
    public void printMemberList() {
        for (TestMember member: memberList) {
            System.out.println(member);
        }
    }

    //ExtensionVariousClassUsageTest
    public void addRandomProduct() {
        // 회원이 대출받을 수 있는 대출비용 천만원 ~ 일억
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3"};
        final String vender = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MAX, DAECHWUL_MIN); // 천만원 x 랜덤숫자

            //TestProduct에 productNameArray[i], vender, price 추가
            productList.add(new TestProduct(productNameArray[i], vender, price));
        }
    }

    //ExtensionVariousClassUsageTest
    public void printProductList() {
        for (TestProduct product: productList) {
            System.out.println(product);
        }
    }

    //ExtensionVariousClassUsageTest
    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;
        // List의 길이는 size()를 통해 구할 수 있습니다.
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            // List 타입에서 get(index)를 지정하면
            // List에 저장된 특정 index의 정보를 얻게 됩니다.
            TestProduct product = productList.get(CustomRandom.generateNumber(2));

            product.setMemberId(CustomRandom.generateNumber(MIN,MAX));
        }
    }
}


