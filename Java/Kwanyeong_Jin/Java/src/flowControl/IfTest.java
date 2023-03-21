package flowControl;

public class IfTest {
    public static void main(String[] args) {
        final int PERMIT_AGE = 18;
        final int inputAge =19;

        // if문 만드는 방법
        // 1. if를 작성하고 소괄호를 작성하고 중괄호를 작성
        // 2. 소괄호 내부에는 조건식을 작성
        // 3. 중괄호 내부에는 조건이 만족된 경우 동작할 코드 작성
        if (PERMIT_AGE < inputAge) {
            System.out.println("입장 가능!");
        }
        else {
            System.out.println("입장 불가!");
        }

        /* 만약 if, else if, else if형태로 코드가 작성되면 조건식을
           첫번째 if가 만족되지 않을 때 else if를 보게 되므로 기본적으로 해당 else if
           는 if의 조건을 만족하지 않음을 내포하므로 else if에서는 맨 처음 if가 만족하지
            않고, 그 다음 else if를 만족하지 않고, 현재의 else if조건을 만족해야 함.
            그러므로 depth가 깊어질술록 코드를 파악하기 위한 혼동이 가중된는 문제 발생
            이 때문에 코드를 작성할 때 if, if, if로 작성하는 것이 좋음
         */
//      final int PERMINT_KIDS = 13;
//      if (PERMINT_KIDS < inputAge) {
//      System.out.println("성인!");
//      } else if (PERMINT_KIDS > inputAge) {
//        System.out.println("아동!");
//    }
    }

}

