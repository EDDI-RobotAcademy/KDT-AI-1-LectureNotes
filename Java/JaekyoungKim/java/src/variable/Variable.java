package variable;

public class Variable {

    public static void main(String[] args) {
        System.out.println("variable(변수) 테스트");

        //변수를 만드는 법
        //1. 데이터 타입을 적는다.(int,float, double, long)
        //   int: 정수형
        //   long : 비슷함
        //   float: 실수형
        //   double: 조금 더 정밀한 소수점
        //2. 변수 이름을 작성한다. (이름은 우리가 만들고 싶은대로 만들 수 있다.)
        //3. 필요하다면 초기화를 진행한다.

        //이렇게 코드를 짜면 변수가 무엇을 뜻하는지 모른다. 직관적인 이름 좋음, 명시성을 철저히
        //같이 작업하는 팀원들에게 뜻이 전달되는 것이 중요하다.
        int appleCount=3;
        int grapeCount=5;
        int totalCount =appleCount+grapeCount;
        System.out.println("과일의 총개수는 "+totalCount+"개입니다.");
        //문자열+숫자의 경우에 앞에 문자열이 나오기 때문애
        //자동으로 숫자를 문자열 처리하여 화면에 출력합니다.

        /*
        int n1 =3,n2=5;
        int res = n"1+n2;
         */
        //아래 이쓴ㄴ [비교 대상]을 보면 3.3f를 직접 기입하고 있으므로
        //향후 프로그램이 커지면 직접 3.3f를 작성한 부분을 모두 찾아서
        //TAX 변경에 따라 모든 코드를 수정해야 하는 부렾ㄴ함이 발생합니다.
        //반면TAX 상수에 숫자를 기입하고 이 상수를 사용한다면
        //변동 사항황이 발생할 때 해당하는 TAX 수치값만
        //변경하면 모든 작어비 일괄처리 되므로 편합니다.
        final float FULL_PERCENT= 100;
        final float TAX =3.3f;
        int income= 1000000;

        System.out.println("프리랜서 세전 수입: "+income+
                ", 새후: "+income*(FULL_PERCENT-TAX)/FULL_PERCENT);
        //final을 사용하는 이유 : 상수로 고정시킬 수 있음
        // 상수로 고정시킬 수 있다는 것의 이점이란 무엇인가?


        /*
        System.out.println("프리랜서 세전 수입: "+income+
                ", 새후: "+income*(FULL_PERCENT-3.3f)/FULL_PERCENT);

         */
        //final 을 사용할 때 가지는 이점 두 번째
        //2. 불변 객체(Immutable Object)
        //클래스를 인스턴스화 하여 객체를 만들었고 이것이 불변이라면 무엇이 좋을까요?
        //TAX =TAX+4
        //위 코드는 TAX가 final 이기 때문에
        //새로운 값을 대입하거나 덧셈, 뺄셈 등등이 불가능합니다.
        //결론적으로 입력되는 값을 변경하지 못하게 막음으로서
        //원래 동작해야 하는 동작의 무결성을 보장하게 됩니다.
        // ㅇ) 1- 예금, 2- 출금, 3-조회
        //회사 프로그램이 만들어져 있는 상태(예금, 출금)
        //신입이 조회를 만들고 있는 상황입니다.
        //만들던 중 코드에 계속, 1과 2가 날아오니까
        //신입은 그냥 들어온 숫자를 3으로 대입하고 문제를 해결했습니다.
        //이 상황에선 예금을 했더니 조회가 되고
        //출금을 했더니 조회가 되고
        //조회를 했더니 조회가 되는 끔찍한 상황이 연출됩니다.
        //이것을 원천 차단하는 방법으로 final을 사용합니다.
        // 3을 대입하는 행위 자체를 차단하는 것이다.
    }
}
