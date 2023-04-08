package variousClassUsage.refactor;

import utility.random.CustomRandom;
import variousClassUsage.refactor.RefactorProduct;

import java.util.ArrayList;
import java.util.List;

public class RefactorManager {

    List<RefactorMember> memberList ;
    List<RefactorProduct> productList ;

    public RefactorManager() {
        memberList = new ArrayList<RefactorMember>();
        productList = new ArrayList<>();
    }


    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;
        final int MAX_EMAIL_LENGTH = 8;
        final int MIN_EMAIL_LENGTH = 4;

        for(int i =0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emaillength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j =0; j < emaillength; j++) {

                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }
            // List 타입 변수.add()를 통해
            // List<데이터 타입>으로 만들었던 테이터 타읿들을 저장할 수 있습니다
            // 그러므로 add 내부에서 new Test Member()를  수행할 수 있습니다.


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
        // productName, String vendor, int price
        final int MIN = 0;
        final int MAX = 0;

        final  int DAECHWUL_MIN = 1;
        final  int DAECHWUL_MAX = 10;

        final String[] productNameArray = {"대출 상품1", "대출 상품2", "대출 상품3"};
        final String vendor = "DAECHUL";

        for (int i = 0; i < productNameArray.length; i++) {
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            productList.add(new RefactorProduct(productNameArray[i], vendor, price));
        }


    }

    public void printProductList() {
        for (RefactorProduct product: productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;
        // List의 길이는 size()를 통해 구할 수 있습니다.
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            //List 타입에서 get(index)를 지정하면
            // List에 저장된 특정 index의 정보를 얻게 됩니다.
            RefactorProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberId(
                    CustomRandom.generateNumber(MIN, MAX));
        }
    }
}
