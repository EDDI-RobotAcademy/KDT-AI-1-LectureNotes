package problems.prob3.prob3change;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Problem3change {
    private static void printRandomCharacterList(List<Character> alphabetList) {
        final int LIST_BIAS =1; // 첫번째 리스트는 0부터 센다. 그거 보정하기

        final int LOOP_NUMBER = 5; //5번 랜덤으로 알파벳 뽑아보자
        for (int i = 0; i < LOOP_NUMBER; i++) {
            int randomIDX = CustomRandom.generateNumber(alphabetList.size()-LIST_BIAS);
            System.out.println(alphabetList.get(randomIDX));
        }

    }
    public static void main(String[] args) {
        //일단 나는 알파벳리스트에 알파벳을 직접 넣었으나 for문 사용해서 코드를 줄여보자
        List<Character> alphabetList = new ArrayList<>();
        char firstAlphabet = 'A'; //"" X, '' 로 써야함
        for (int i = 0; i < 10; i++) {
            alphabetList.add((char)(firstAlphabet +i));
        }

        //랜덤 알파벳 출력
        printRandomCharacterList(alphabetList);
    }


}
