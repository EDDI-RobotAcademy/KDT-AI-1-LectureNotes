package homework.fifth.refactor.productReview;

import homework.fifth.refactor.HomeworkMember;
import homework.fifth.refactor.HomeworkProduct;
import utility.generator.SquenceGenerator;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class HomeworkManager {

    List<HomeworkMember> memberList;
    List<HomeworkProduct> productList;

    public HomeworkManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addRandomMember(){
        final int MAX_MEMBER_NUMBER = 5;

        for(int i=0; i<MAX_MEMBER_NUMBER; i++){
            addMember();
        }
    }

    public void addMember() {
        final int MIN_EMAIL_LEN = 4;
        final int MAX_EMAIL_LEN = 8;

        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LEN, MAX_EMAIL_LEN);
        for (int j = 0; j < emailLength; j++) {
            tmpString += (char) CustomRandom.generateNumber('a', 'z');
        }
        memberList.add(new HomeworkMember(
                SquenceGenerator.getCurrentSequenceMemberId(), tmpString + "@test.com", "test"));
    }

    public void printMemberList() {
        for (HomeworkMember member : memberList) {
            System.out.println(member);
        }
    }


    public void addRandomProduct() {

        final String[] productNameArray = {"대출 상품1", "대출 상품2", "대출 상품3"};
        final String vendor = "DAECHWUL";

        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        for (int i = 0; i < productNameArray.length; i++) {
            int price = CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX) * 10000000;
            productList.add(new HomeworkProduct(
                    productNameArray[i], vendor, price));
        }
    }

    public void printProductList() {
        for (HomeworkProduct product : productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 1;
        final int MAX = 5;
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            HomeworkProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberID(CustomRandom.generateNumber(MIN, MAX));
        }
    }
}