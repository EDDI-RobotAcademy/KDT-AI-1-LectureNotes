package problems.prob3;

import customLibrary.utility.CustomRandom;

public class Problem3 {
    public static void main(String[] args) {
        final String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        int randomResult = CustomRandom.generateNumber(alphabet.length - 1);
        System.out.println(alphabet[randomResult]);
    }
}

// 3. “A”, “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “J” 문자열 10개를 리스트에 넣고 랜덤으로 출력해봅시다.