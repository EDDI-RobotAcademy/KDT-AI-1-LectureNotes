package homework.homework5.refactor;
import utility.generator.SequenceGenerator;
import utility.random.CustomRandom;
import variousClassUsage.refactor.RefactorMember;
import variousClassUsage.refactor.RefactorProduct;
import java.util.ArrayList;
import java.util.List;

public class RefactorManager2 {
    List<RefactorMember> memberList;
    List<RefactorProduct> productList;

    public RefactorManager2() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public void addRandomMember() { //랜덤멤버번호부여함수
        final int MAX_MEMBER_NUMBER = 5;
        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) { //멤버수만큼반복
            addMember();//멤버추가함수 (1.멤버 이메일만들기, 2. memberList에 요소를 추가한다)
        }
    }

    public void addMember () { //<<멤버추가함수>>
        final int MIN_EMAIL_LENGTH = 4; //1. 멤버 이메일만들기
        final int MAX_EMAIL_LENGTH = 8;

        String tmpString = "";
        int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

        for (int j = 0; j < emailLength; j++) {
            tmpString += (char) CustomRandom.generateNumber('a', 'z');
        }

        memberList.add( //2. memberList에 아래 요소를 추가한다
                //RefactorMember(int memberId, String email, String password)  -->멤버정보
                new RefactorMember(SequenceGenerator.getCurrentSequenceMemberId(), tmpString + "@test.com", "test"));
    }

    public void printMemberList () {    //<<멤버리스트 출력함수>>
        for (RefactorMember member: memberList) { //for each문 -
            System.out.println(member);           //-memberList의 요소인 RefactorMember member를 하나씩 모두 출력
        }
    }

    public void addRandomProduct() { //<<랜덤상품추가함수>>
        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        final String[] productNameArray = { "대출상품1", "대출상품2", "대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++) { //productNameArray의 요소 개수만큼 반복
            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN, DAECHWUL_MAX);
            productList.add(    //productList에 아래 요소를 추가한다.
                    new RefactorProduct(productNameArray[i], vendor, price));
                        //RefactorProduct(String productName, String vendor, int price)
                        //productNameArray[1] ~ productNameArray[i(현재=3)]
        }
    }

    public void printProductList () {   //<<랜덤상품리스트 출력함수>>
        for (RefactorProduct product: productList) {//for each문 -
            System.out.println(product);            //-productList의 요소인 RefactorProduct product를 하나씩 모두 출력

        }
    }

    public void buyRandomProduct() {    //<<랜덤상품구매함수>>
        final int MIN = 0;
        final int MAX = 4;

        int productLength = productList.size(); //productList의 요소개수

        for (int i = 0; i <productLength; i++) {//productList의 요소개수만큼 반복
            RefactorProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberId(    //memberIdList에 요소로 아래 memberId를 추가;
                    CustomRandom.generateNumber(MIN, MAX));
        }
    }
}