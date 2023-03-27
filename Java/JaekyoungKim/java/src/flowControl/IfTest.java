package flowControl;

public class IfTest {
    public static void main(String[] args) {
        final int PERMIT_AGE = 18;
        final int inputAge= 15;
        //if 문을 만드는 방법
        // 1. if를 작성하고 소괄호와 중괄호 작성합니다.
        // 2. 소괄호 내부에 조건식을 작성합니다.
        // 3. 중괄호 내부에 조건이 만족된 경우 동작할 코드를 작성합니다.
        // 4. else if 보다  if가 가독성이 더 크다.
        if (PERMIT_AGE<inputAge){
            System.out.println("입장 가능하십니다.");
        } else {
            System.out.println("입장 불가능하십니다.");
        }
        final int PERMIT_KIDS= 13;
        if(PERMIT_AGE<inputAge){
            System.out.println("성인용입니다.");
        }
        if(PERMIT_KIDS<inputAge){
            System.out.println("아동용입니다.!");
            //만약 if, else if, else if, else, if 형태로 코드가 작성되면
            //조건식을 처 번째 if가 만족되지 않았을 때 else if를 보게 되므로
            //기본적으로 해당  else if에서는 if의 조건 또한 만족하지 않음을 내포하게 됩니다.
            //그리고 그 다음 else if 에서는 맨 처음 if가 만족하지 않고, 그 다음 else 를 만족하지 않고
            //현재의 else if 조건을 만족해야 합니다.
            //depth가 깊어질수록 코드를 파악하기 위한 혼동이 가중된다는 문제가 있습니다.
            // 이와 같은 이유 때문에 코드를 작성할 때 if, else if 보단 if, if, if 가 더 좋다.
            //(서비스 개발자라는 전제를 두고)


        }
        }

}
