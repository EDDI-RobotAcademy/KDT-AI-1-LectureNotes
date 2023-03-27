package flowControl;

public class WhileTest {
    public static void main(String[] args) {
        // While 문 작성 방법
        // 1. 일단 while을 적고 소괄호()를 작성하고 중괄호를 작성합니다.
        // 2. 소괄호 내부에 조건식을 작성합니다.
        //      <<<--- idx < 10 의 엄밀한 뜻은 아래와 같스빈다.
        //      idx변수의 값이 숫자 10보다 작은게 맞니? 라고 물어보는 것입니다.
        //      그리고 그 답으로 true 혹은 false가 튀어나옵니다.
        //      while(true) 혹은 while(false)로 치환되므로
        //      조건이 만족되면 루프를 돌고 만족되지 않으면 루프를 빠져나오게 됩니다.
        // 3. 중괄호 내부에 조건이 만족되는 동안 반복시킬 코드를 작성합니다.

        int idx = 0;
        final char ch = 'A';
        while (idx < 10) {
            System.out.println("idx: " + idx + ", 안녕: "+ (char)(ch + idx));
            // char 타입의 변수들은 독특한 특성을 가지고 있습니다.
            // ASCII 코드 특성인데 실제 알파벳 'A'는 숫자 65에 해당합니다.
            // 이와 같은 이유로 실질적으로 숫자값들과 덧셋, 뺄셈등의 연산을 수행할 수 있습니다.
            // 위 규칙에 따르면 'B'는 66ㅣ라는 것도 알 수 있습니다.
            idx++;
        }
    }
}
