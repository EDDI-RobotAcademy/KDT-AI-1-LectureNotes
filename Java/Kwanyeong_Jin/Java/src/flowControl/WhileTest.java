package flowControl;

public class WhileTest {

    public static void main(String[] args){
        int idx = 0;
        char ch = 'A';
//        while문 작성 방법
//        1. while을 적고 ()작성후 {} 작성
//        2. () 내부에 조건식 작성
//           idx < 10은 idx 변수의 값이 10보다 작은게 맞는지 물어보는 것
//           답은 True oder False가 되며 while(true) oder while(false)로 치환
//           조건이 만족되면 루프를 돌고 비만족되면 루프를 빠져 나옴
//        3. {} 내부에 조건이 만족되는 동안 반복시킬 코드 작성
        while (idx < 10) {
            System.out.println("idx : " + idx +", 안녕 : " + (char)(ch + idx));
            // char 타입의 변수들은 ASCII 코드에서 'A'는 65에 해당
            // 하여 숫자들과 연산 수행이 가능하여 (ch + idx) = 66이 되어 B임을 앎
            idx++;
        }

    }


}
