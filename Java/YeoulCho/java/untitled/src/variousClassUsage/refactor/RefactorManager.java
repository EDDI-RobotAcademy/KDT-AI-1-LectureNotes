package variousClassUsage.refactor;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorManager {
    List<RefactorMember> memberList;
    List<RefactorProduct> productList;

    public RefactorManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addRandomMember() {//랜덤으로 멤버를 생성하자, 5명
        final int MAX_MEMBER_NUMBER = 5;

        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);
            //4~8 에서 랜덤 숫자로 이메일만들기

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }//글자 길이만큼돌면서 문자배열 추가
            memberList.add(new RefactorMember(i, tmpString + "@test.com", "test"));
        }
    }

    public void printMemberList() {
        for (RefactorMember member : memberList) {
            System.out.println(member);
        }

    }

    public void addRandomProduct() { //천만원~1억까지 대출상품 만들어보자
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        final String[] productNameArray = {"대출상품1", "대출상품2", "대출상품3"};
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            productList.add(new RefactorProduct(productNameArray[i], vendor, price));
        }
    }


    public void printProductList() {
        for (RefactorProduct product : productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() { //5명의 회원중 4명의 회원이 제품을 산다
        final int MIN = 0;
        final int MAX = 4;

        for (int i = 0; i < productList.size(); i++) {
            RefactorProduct product = productList.get(CustomRandom.generateNumber(2));

            product.setMemberIdList(
                    CustomRandom.generateNumber(MIN, MAX)
            );

        }


    }

    public void findProduct1Buyer(int productIndex) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductName().equals("대출상품" + productIndex)) {
                System.out.println(productList.get(i));
            } // productList의 0번째 productName 이름이 대출상품1이면 구매자를 내놔
        }
    }
}







