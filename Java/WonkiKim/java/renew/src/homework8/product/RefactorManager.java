package homework8.product;


import homework8.member.Member;
import utility.generator.SequenceGenerator;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RefactorManager {
    List<Member> memberList;
    List<RefactorProduct> productList;


    public RefactorManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addManyMember(int numberOfMember) {
        final int ADD_MEMBER_NUMBER = numberOfMember;

        for (int i = 0; i < ADD_MEMBER_NUMBER; i++) {
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

        memberList.add(new Member(
                SequenceGenerator.getSpecificEntityId("Member"),
                tmpString + "@test.com", "test"));
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
            RefactorProduct product = productList.get(
                    CustomRandom.generateNumber(productList.size()-1));

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, MAX));
        }
    }

    public List<Integer> getMemberIdByingProduct(RefactorProduct product) {
        return product.getMemberIdList();
    }

    public List<RefactorProduct> getProductList() {
        return productList;
    }

    public void printMemberListPurchaseProduct() {
        for(RefactorProduct product: getProductList()) {
            System.out.println(product.getProductName() +"을 구매하신 고객님의 정보는 ");
            if (getMemberIdByingProduct(product).size() != 0) {
                for(Integer i: getMemberIdByingProduct(product)){
                    System.out.print("memberId = " + i+ ", ");
                    System.out.println(Member.getMemberInfo(i));
                }
            } else {
                System.out.println("없습니다.");
            }

        }
    }
}