package homework.productHomework2.product;

import homework.productHomework2.member.Member;
import utility.generator.SequenceGenerator;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RefactorManager {
    // 멤버 값을 리스트로 저장
    List<Member> memberList;
    // 제품 값을 리스트로 저장
    List<RefactorProduct> productList;

    public RefactorManager() {
        // 멤버리스트 프로덕트 리스트를 메모리에 할당
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    // 랜덤으로 결정된 아이디를 for를 통해 돌면서 아이디를 할당
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            addMember();
        }
    }

    public void addMember () {
        // 아이디의 길이 설정
        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

        for (int j = 0; j < emailLength; j++) {
            tmpString += (char) CustomRandom.generateNumber('a', 'z');
        }

        memberList.add(new Member(
                // 멤버라는 값으로 리스트에 저장  패스워드는 일제히 테스트로 저장
                SequenceGenerator.getSpecificEntityId("Member"),
                tmpString + "@test.com", "test"));
    }

    public void printMemberList () {
        // for each를 이용해 모든 멤버리스트를 출력
        for (Member member: memberList) {
            System.out.println(member);
        }
    }

    public void addRandomProduct() {

        // 대출 최솟값부터 최댓값 설정 1천만~1억
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        // 대출상품 명을 리스트에 저장
        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            // 리팩터프로덕트  초기화 선언(String productName, String vendor, int price) 프라이스에 할당
            productList.add(new RefactorProduct(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList () {
        // for each를 이용해 모든 프로덕트리스트 출력
        for (RefactorProduct product: productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        // 무작위 상품구매 매서드
        final int MIN = 0;
        final int MAX = 4;

        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            RefactorProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, MAX));
        }
    }
}