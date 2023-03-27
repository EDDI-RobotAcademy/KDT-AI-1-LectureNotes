package variable;
public class Variable_Test {
    public static void main(String[] args) {
        System.out.println("variable(변수) 테스트");
        //변수를 만드는 방법
        // 1. 데이터 타입을 적는다 (int, float, double, long)
        //      int : 정수형(숫자 - 음양수)
        //      long :
        //      float : 소수
        //      double : 조금 더 정밀한 소수(사용할 일 드뭄)
        // 2. 변수 이름을 작성(이름은 아무거나 가능하나 "직관적인 이름이 효율성 높음")
        // 3. 필요하다면 초기화 진행

        // 변수 이름은 명시성을 통해 함께 작업하는 팀원들에게 이것이 무엇을 의미하는 것인지 명확하게
        // 전달하는것이 가장 중요

        /*
        int n1 = 3, n2 = 5;
        int res = n1 + n2;
         */
        int appleCount = 3;
        int grapeCount = 5;
        int totalCount = appleCount + grapeCount;
        // 문자열 + 숫자의 경우엔 앞에 문자열이 나왔기 때문에
        // 자동으로 숫자를 문자열 처리하여 화면에 출력
        System.out.println("totalCount = " + totalCount);

        // final을 사용하는 이유 : 우선 상수로 고정시킬 수 있다는 이점이 있음
        // 상수로 고정시킬 수 있다는 것의 이점은?
        // 1. [비교대상]에서는 3.3f를 직접 기입하고 있어 향후 프로그램이 커지면 직접 3.3f를 작성한 부분을 모두 찾아서
        //    TAX 변경에 따라 모든 코드를 수정해야 하는 불편함이 발생
        //    반면 TAX 상수에 숫자를 기입하고 이 상수를 사용한다면 변동 상항이 발생할 때마다 해당하는 TAX 수치값만
        //    한번 변경하면 모든 작업이 일괄처리 되어 편함
        // 2. 불변 객체 (Immutable Object)
        //    클래스를 인스턴스화하여 객체를 만들었을 때 이것이 불변이라면
        //    TAX = TAX =4;
        //    위 코드는 TAX가 final이기 때문에 새로운 값을 대입하거나 연산들이 불가능
        //    입력되는 값을 변경하지 못하게 하므로서 원래 동작해야 하는 동작의 무결성을 보장
        //    ex) 1 - 예금, 2 - 출금, 3 - 조회
        //    회사 프로그램이 만들어져 있는 상태(예금, 출금)
        //    신입이 조회를 만들고 있는 상황으로 만들던 중 코드에 계속 1과 2가 날아오니까
        //    신입은 그냥 들오온 숫자를 3으로 대입하고 문제를 해결
        //    이 상황에선 예금을 했더니 조회가 되고 출금을 해도 조회가 되고 조회를 하니 조회가 된느 상황이 연출
        //    이것을 원천 차단하는 방법으로 final을 사용하여 3을 대입하는 행위 자체를 차단
        final float FULL_PERCENT = 100;
        final float TAX = 3.3f;
        int income = 1000000;

        System.out.println("수입 : " + income +
                ", 세후 : " + income * (FULL_PERCENT - TAX) / FULL_PERCENT);
//      [비교 대상]
//      System.out.println("수입 : " + income +
//                ", 세후 : " + income * (FULL_PERCENT - 3.3f) / FULL_PERCENT);

    }
}
