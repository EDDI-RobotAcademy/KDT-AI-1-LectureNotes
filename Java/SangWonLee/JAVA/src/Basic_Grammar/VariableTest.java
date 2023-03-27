package Basic_Grammar;

public class VariableTest {

    public static void main(String[] args) {
        System.out.println("variable(변수) 테스트");

/*
        변수를 만드는 방법
        1. 데이터 타입을 적는다. (int, float, double, long)
        int : 정수형 (숫자 - 음수, 양수)
        long : 비슷함
        float : 소수점
        double : 조금 더 정밀한 소수점 (실제 작업하면서 double 사용할 일은 거의 드물다.)
        2. 변수 이름을 작성한다. (이름은 우리가 만들고 싶은대로 만들 수 있다.)
        3. 필요하다면 초기화를 진행한다.
*/
        int applCount = 3;
        int grapeCount = 5;
        int totalCount = applCount + grapeCount;

        System.out.println("totalCount = " + totalCount); //totalCount = 8

//      final을 사용하는 이유 : 상수로 고정시킬 수 있따는 이점이 있다.

        final  float FULL_PERCENT = 100;
        final  float TAX = 3.3f;
        int income = 1000000;

        System.out.println("프로랜서 세전 수입 : " + income +", 세후 : " + income
                * (FULL_PERCENT - TAX) / FULL_PERCENT);
        // 프로랜서 세전 수입 : 1000000, 세후 : 967000.0



    }
}
