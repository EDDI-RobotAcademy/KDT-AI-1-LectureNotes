package rep;

import homework.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomIntegerListTest {
    public static void main(String[] args) {
        // ListTest는 연속된 숫자 표현
        // 아래 코드는 랜덤 정수
        // <Integer> 에는 스트링이 들어갈 수 있다. (= 원하는 타입으로 사용)
        List<Integer> randomIntegerList = new ArrayList<>();

        for (int i = 0; i < 3; i++)
        {
            // add에 무엇을 넣느냐를 생각하기
            // 지금은 CustomRandom 숫자를 넣음
            randomIntegerList.add(CustomRandom.generateNumber(7,33)); //
            System.out.println("결과 출력:" + randomIntegerList.get(i));
        }

    }
}
