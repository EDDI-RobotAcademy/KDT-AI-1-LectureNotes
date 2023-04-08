package variousClassUsageTest.refactor;

import utility.random.CustomRandom;
import variousClassUsageTest.TestMember;
import variousClassUsageTest.TestProduct;

import java.util.ArrayList;
import java.util.List;

public class RefactorManager {
    // ArrayList는 일종의 배열입니다.
    // 하지만 일반적인 배열과는 차이점을 가지고 있습니다.
    // 예로 0,1,2,3,4,5,6,6,6,7,8,9,10....인 형태로 배열이 있습니다.
    // 숫자 6을 전부 지우고 뒤쪽에 9,10을 앞으로 땡기고 싶다면  어떤 일이 발생할까요?
    // 6 3개를 지우기 위해 100개 분량의 데이터가 이동해야 합니다.
    // 효율적인 처리를 위해 아래와 같은 방식을 사용
    // [0, 다음링크] -> [1, 다음링크] -> [2, 다음링크] ->[3, 다음링크] ->[4, 다음링크] -> [5, 다음링크] ->
    // [6, 다음링크] -> [6, 다음링크] -> [6, 다음링크] -> [7, 다음링크] -> [8, 다음링크] ->.........
    // 위와 같을시 6을 정리하는 것은 간단합니다.
    // [5, 다음링크]에서 [7, 다음링크]을 가리키도록 하는 것입니다. 그럼 6의 정보는 떨어지게 됩니다.

    //사용법
    // 1. List<데이터타입> 작성
    // 2. 리스트 변수명 작성
    // 3. new ArrayList<>;를 작성하여 리스트 객체 생성
    List<variousClassUsageTest.TestMember> memberList;
    List<RefactorTestProduct> productList;


    public RefactorManager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    //랜덤한 이메일을 만들어줘야함
    // 앞에 글자 4~8개 정보를 런덥으로 뽑자!
    // 뒤에느 @test.com을 붙이자
    // 5명 정보 만들자
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;

        final int MIN_EMAIL_LENGTH = 4;
        final int MAX_EMAIL_LENGTH = 8;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LENGTH, MAX_EMAIL_LENGTH);

            for (int j = 0; j < emailLength; j++) {
                tmpString += (char)CustomRandom.generateNumber('a', 'z');
            }
//            System.out.println(tmpString + "@test.com");
//            List 타입 변수.add()를 통해 List<데이터타입>으로 만들었던 데이터타입들을 저장가능
//            add내부에서 new TestMember()를 수행 가능
            memberList.add(new variousClassUsageTest.TestMember(
                    i, tmpString + "@test.com", "test"));
        }
    }

    public void printMemberList() {
        for (TestMember member : memberList) {
            System.out.println(member);

        }
    }

    public void addRandomProduct() {
        //String productName, String vendor, int price

        final int DAECHWUL_MIN =1;
        final int DAECHWUL_MAX =10;

        final String[] productNameArray = {"대출상품1","대출상품2","대출상품3" };
        final String vendor = "DAECHWUL";

        for (int i = 0; i < productNameArray.length; i++){

            int price = 10000000 * CustomRandom.generateNumber(DAECHWUL_MIN,DAECHWUL_MAX);
            productList.add(new RefactorTestProduct(productNameArray[i], vendor, price));
            }
    }

    public void printProductList() {
        for (RefactorTestProduct product: productList){
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 0;
        final int MAX = 4;
        // List의 길이는 size()를 통해 구할 수 있음
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++){
            // List 타입에서 get(index)를 지정하면
            // List에 저장된 특정 index의 정보를 얻게 됨
            RefactorTestProduct product = productList.get(CustomRandom.generateNumber(2));

            product.setMemberId(CustomRandom.generateNumber(MIN, MAX));



        }

    }
}











