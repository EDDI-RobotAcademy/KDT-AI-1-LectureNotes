package examPractice;

import utility.sequence.NumberSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 5. 아래와 같은 숫자 나열이 있습니다.
// 3, 3, 3, 6, 9, 12, 18, 27, 39, 57, …
// 이 숫자 나열의 20번째엔 어떤 숫자가 있을지 프로그램을 작성해보세요.
// 원기님꺼도 참고할 것
public class Prob5 {
    // 일단 선생님 코드보고 필요한 메서드 먼저 만들기

    public static void main(String[] args) {
        final Integer[] initArr = {3, 3, 3};
        final List<Integer> numberList = new ArrayList<>(Arrays.stream(initArr).toList());
        final NumberSequence numberSequence = new NumberSequence(numberList);
        // 여기서 매개변수에 들어가는가야 하는건 리스트 -> 초기화해주기
        final int fidvalue = numberSequence.applyProb5Rules(20);
        System.out.println("20번째 항은 " + fidvalue);
    }
}
