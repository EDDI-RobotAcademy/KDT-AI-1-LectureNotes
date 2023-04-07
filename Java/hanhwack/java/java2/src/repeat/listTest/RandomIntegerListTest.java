package repeat.listTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomIntegerListTest {

    public static void main(String[] args) {
        //<>안에는 묶음으로 관리하고 싶은 데어터타입을 기입
        List<Integer> randomInteegerList = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            randomInteegerList.add(CustomRandom.generateNumber(7, 33));
            System.out.println("결과 출력: " + randomInteegerList.get(i));
        }
    }
}
