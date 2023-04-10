package problems.prob3;

//3. “A”, “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “J” 문자열 10개를 리스트에 넣고 랜덤으로 출력해봅시다.


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Problem3 {
    public static void main(String[] args) {
        Random random = new Random();

        final int Alphabet = 10;
        final List<String >test = Arrays.asList("A","B","C","D","E","F","G","H","I","J");

        int randomIndex = random.nextInt(test.size());
        System.out.println(test.get(randomIndex));

    }
}
