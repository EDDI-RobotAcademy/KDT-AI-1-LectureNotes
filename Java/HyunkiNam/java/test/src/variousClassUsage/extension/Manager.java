package variousClassUsage.extension;

import utility.random.CustomRandom;
import variousClassUsage.TestMember;
import variousClassUsage.TestProduct;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    // ArrayList는 일종의 배열
    // 하지만 일반적인 배열과는 다른점을 가지고 있다.
    // 예를 들어 0, 1, 2, 3, 4, 5, 6, 6, 6, 9, 10, ..... 형태의 배열이 있다면
    // (대략 100개의 정보가 더 존재)
    // 중복인 숫자 6을 전부 지우고 뒤쪽에 9, 10을 앞으로 땡기고 싶다면 어떤 일이 발생할까?
    // 정보 3개를 지우기 위해 100의 데이터가 이동해야 하는 상황 발생

    // 그래서 보다 효율성이 높은 방식인
    // [0, 다음링크] -> [1, 다음링크] -> [2, 다음링크] -> [3, 다음] -> [4, 다음]
    // -> [5, 다음] -> [6, 다음] -> [6, 다음] -> [6, 다음] -> [9, 다음] -> ...
    // [5, 다음]에서 다음을 [9, 다음]을 가리키도록 만드는 방식
    // 그럼 알아서 [6, 다음] -> [6, 다음] -> [6, 다음]은 떨어지게 됨
    // 100개의 데이터를 이동시키기보다는 연결되어 있는 링크선 하나 변경하는게 좋다.

    // 사용 방법
    // - List<데이터타입> 변수명 = new ArrayList<>();
    // new ArrayList<>(); 로 리스트 객체 생성
    List<TestMember> memberList;
    List<TestProduct> productList;

    public Manager() {
        memberList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    // 랜덤 이메일을 만들어야함
    // 앞에 글자 4~8개 정도를 랜덤으로 뽑고
    // 뒤에는 @test.com을 붙이도록 한다.
    // 5명 정도 만든다고 가정
    public void addRandomMember() {
        final int MAX_MEMBER_NUMBER = 5;
        final int MIN_EMAIL_LEN = 4;
        final int MAX_EMAIL_LEN = 8;

        for (int i = 0; i < MAX_MEMBER_NUMBER; i++) {
            String tmpString = "";
            int emailLength = CustomRandom.generateNumber(MIN_EMAIL_LEN, MAX_EMAIL_LEN);
            for (int j = 0; j < emailLength; j++) {
                tmpString += (char) CustomRandom.generateNumber('a', 'z');
            }
            // List 타입 변수.add()를 통해
            // List<데이터타입>으로 만들었던 데이터타입들을 저장할 수 있다.
            // 그러므로 add 내부에서 new TestMember()를 수행할 수 있다.
            memberList.add(new TestMember(
                    i + 1, tmpString + "@test.com", "test"));
        }
    }

    public void printMemberList() {
        for (TestMember member : memberList) {
            System.out.println(member);
        }
    }

    public void addRandomProduct() {

        final String[] productNameArray = {"대출 상품1", "대출 상품2", "대출 상품3"};
        final String vendor = "DAECHWUL";

        final int DAECHWUL_MIN = 1;
        final int DAECHWUL_MAX = 10;

        for (int i = 0; i < productNameArray.length; i++) {
            int tmpPrice = (int) (Math.random() * (DAECHWUL_MAX - DAECHWUL_MIN + 1) + DAECHWUL_MIN) * 10000000;
            productList.add(new TestProduct(productNameArray[i], vendor, tmpPrice));
        }
    }

    public void printProductList() {
        for (TestProduct product : productList) {
            System.out.println(product);
        }
    }

    public void buyRandomProduct() {
        final int MIN = 1;
        final int MAX = 5;
        // List의 길이는 size()
        int productLength = productList.size();

        for (int i = 0; i < productLength; i++) {
            // List 타입에서 get(index)를 지정하면
            // List에 저장된 특정 index의 정보를 얻게 된다.
            TestProduct product = productList.get(
                    CustomRandom.generateNumber(2));

            product.setMemberID(CustomRandom.generateNumber(MIN, MAX));
        }
    }
}