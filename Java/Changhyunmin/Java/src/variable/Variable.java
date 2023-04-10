package variable;

public class Variable {
    public static void main(String[] args) {
        System.out.println("variable(변수) 테스트");

        //변수를 만드는 방법
        //1. 데이터 타입을 적는다 (int, float, double, long)
        //  int: 정수형(숫자 - 음수, 양수)
        //  long: ㄴ비슷함
        //  float: 소수점
        //  double: 조금 더 정밀한 소수점 (실제 작업하면서 double 사용할 일은 거의 드믐)
        //2. 변수 이름을 작성한다(이름은 우리가 만들고 싶은대로 만들 수 있다.)
        //3. 필요하다면 초기화를 진행한다.

        //결론적으로 변수를 만들 때 가장 중요한 것은
        //변수 이름인데 명시성을 통해 함께 작업하는 팀원들에게
        //이것이 무엇을 의미하는 것인지 명확하게 전단하기 위한 목적이 가장 중요합니다.
        int appleCount = 3;
        int grapeCount = 5;
        int totalCount = appleCount + grapeCount;
        /*
        int n1 = 3,  n2 =5;
        int res = n1 + n2;
         */

        //문자영 + 숫자의 걍우엔 앞에 문자열이 나왔기 때문에
        //자동으로 숫자를 문자열로 처리하여 화면에 출력한다.
        System.out.println("totalCount = " + totalCount);

        //final을 사용허는 이유: 우선 상수를 고정시킬 수 있다는 이점이 있음
        //상수로 고정시킬 수 있다는 것의 이점이란 무엇인가?

        //1. 아래 있는 [비교 대상]을 보면 3.3f를 직접 기입하고 있으므로
        //  향후 프로그램이 커지면 직접 3.3f를 작성한 부분을 모두 찾아서
        //  TAX 변경에 따라 모든 코드를 수정해야 하는 불편함이 발생합니다.
        //  반면 TAX 상수에 숫자를 기입하고 이 상수를 사용한다면
        //  변동상황이 발생할 때 해당하는 TAX 수치값만
        //  한 번 변경하면 모든 상황을 바로 고칠수있다.
        // 메서드 쪽으로 보면 int income만 사용해도 좋지만 DB관점에서는 final int income을 사용하면 좋다.
        final float FULL_PERCENT = 100;
        final float TAX = 3.3f;
        int income = 1000000;
        System.out.println("프리랜서 세전 수입:" + income + ", 세후"
                + income * (FULL_PERCENT - TAX) / FULL_PERCENT);

        /*( 비교 대상 )
        System.out.println("프리랜서 세전 수입:" + income + ", 세후"
                + income * (FULL_PERCENT - 3.3f) / FULL_PERCENT);
         */

        //final을 사용할 때 가지는 이점 두 번째
        //2.불변 객체 (Immutable Object)
        //클래스를 인스턴스화 하여 객체를 만들었고 이것이 불변이라면 무엇이 좋을까요?

        //TAX = TAX + 4;
        //위 코드는 TAX 가 final 이기 때문에
        //새로운 값을 대입하거나 덧셈, 뻴셈 등등이 불가합니다.
        //결과적으로 입력되는 값을 변경하지 못하게 막음으로서
        //원래 동작해야 하는 동작의 무결성을 보장하게 됩니다.

        //Ex) 1 - 예금, 2 - 출금, 3 - 조회
        //회사 프로그램이 만들어져 있는 상태(예금, 출금)
        //신입이 조회를 만들고 있는 상황입니다.
        //만들던 중 코드에 계속 , 1과 2가 날아오니까
        //신입은 그냥 들어온 숫자를 3으로 대입하고 문제를 해결했습니다.
        //이상황에선 예금을 했더니 조회가 되고
        //출금을 했더니 조회가 되고
        //조회를 했더니 조회가 되는 끔찍한 상황이 연출됩니다.
        //이것을 원천 차단하는 방법으로 final을 사용합니다.
        //3을 대입하는 행위 자체를 차단하는 것이죠.
    }
}
