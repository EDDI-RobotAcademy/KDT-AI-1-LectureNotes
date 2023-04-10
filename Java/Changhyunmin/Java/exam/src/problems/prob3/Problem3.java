package problems.prob3;

import java.util.Random;

public class Problem3 {
    public static void main(String[] args) {
        //3. “A”, “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “J” 문자열 10개를 리스트에 넣고 랜덤으로 출력해봅시다.
        //'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'
        String[] message = {"A","B","C","D","E","F","G","H","I","J"};
        int RandomArray = 10;
        Random random = new Random();
        System.out.println(message[random.nextInt(RandomArray)]);
    }
}
