package homework.fourth.product;

import utility.random.CustomRandom;
import variousClassUsage.TestMember;
import variousClassUsage.TestProduct;

import java.util.ArrayList;
import java.util.List;

public class HomeworkManager {
    List<HomeworkMember> memberList;
    List<HomeworkProduct> productList;

    public HomeworkManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    // 5명의 회원을 만들고, 랜덤 이메일을 배정해서 정보를 정리할거야
    // 근데 5명이 아니라면? 랜덤의 숫자로 들어온다면?
    public int addRandomMember() {
        int MAX_MEMBER_NUMBER;

        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;
        MAX_MEMBER_NUMBER = CustomRandom.generateNumber(1, 5); // 1~5명 중 랜덤 생성

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }

            memberList.add(new HomeworkMember(
                    i, tmpString + "@test.com", "test"));
        }
        return MAX_MEMBER_NUMBER;
    }

    public void printMemberList () {
        for (HomeworkMember member: memberList) {
            System.out.println(member);
        }
    }

    // 랜덤한 상품 3개 만들기
    public void addRandomProduct() {
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            productList.add(new HomeworkProduct(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList () {
        for (HomeworkProduct product: productList) {
            System.out.println(product);
        }
    }

    // 어떤 멤버가 어떤 상품을 구매했는지 확인하는 코드
    public void buyRandomProduct() {
        final int MIN = 0;
        int MEMBER_NUM = memberList.size(); // MIN 1에서 MAX 5가 될 수 있다

        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            HomeworkProduct product = productList.get(
                    CustomRandom.generateNumber(2)); // 상품 3개 중 하나 가져오기?

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, (MEMBER_NUM-1))); // 멤버 0부터 4 중 1명 선택
        }
    }
}