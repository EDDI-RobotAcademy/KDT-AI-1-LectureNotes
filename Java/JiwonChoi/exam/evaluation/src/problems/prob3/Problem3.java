package problems.prob3;

import customLibrary.Random;

import java.util.ArrayList;

/*
3. “A”, “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “J” 문자열 10개를 리스트에 넣고 랜덤으로 출력해봅시다.
*/
public class Problem3 {
    public static void main(String[] args) {

        ArrayList<Character> abcList = new ArrayList<Character>();
        for(char i = 'A'; i <= 'J' ; i++ ) {
            abcList.add(i);
        }
        int randomIndex = Random.randomNumber(abcList.size());

        System.out.println(abcList.get(randomIndex));
    }
}
