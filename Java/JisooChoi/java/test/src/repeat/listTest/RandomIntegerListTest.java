package repeat.listTest;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class RandomIntegerListTest {
    public static void main(String[] args) {
        List<Integer> randomIntegerList = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            randomIntegerList.add(CustomRandom.generateNumber(7, 33));
            System.out.println("결과 출력: "+randomIntegerList.get(i));
        }
    }
}
