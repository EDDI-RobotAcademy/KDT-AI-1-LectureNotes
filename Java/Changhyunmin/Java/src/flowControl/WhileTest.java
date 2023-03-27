package flowControl;

public class WhileTest {
    public static void main(String[] args) {
        int idx = 0;
        char ch = 'A';

        //While 문 작성 방법
        //1. 일단  While을 적고 소괄호()를 작성하고 중괄호{}를 작성한다.
        //2. 소괄호 내부에 조건식을 작성합니다.
        //  <<< idx < 10의 엄밀한 뜻은 아래와 같습니다.
        //  idx 변수의 값이 숫자 10 보다 작은게  맞니? 라고 물어보는것입니다.
        //  그리고 그 답으로 참(True) 혹은 거짓 (False)이 튀어 나옵니다.
        //  While(True) 혹은 While(False)로 치환되므로
        //  조건이 만족되면 루프를 돌고 만족되지 않으면 루프를 빠져나오게 됩니다.
        //3. 중괄호 내부에 조건이 만족되는 동안 반복 시킬 코들르 작성합니다.

        while (idx < 10) {

            System.out.println("idx:" +idx + "안녕:" + (char)(ch + idx));
            idx++;
            //char 타입의 변수들은 독특한 특성을 가지고 있습니다.
            //ASCII코드 특성인데 실제 알파벳 'A'는 숫자 65에 해당합니다.
            //이와 같은 이유로 실질적으로 숫자값들과 덧셈, 뻴셈들의  연산을 수행할 수 있습니다.
            //위의 규칙에 따르면 'B'는 66이라는 것도 알 수 있습니다.
        }

    }


}
