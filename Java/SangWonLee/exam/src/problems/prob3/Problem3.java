package problems.prob3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {

        String[] english = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        List<String> englishList = new ArrayList<>(List.of(english));

        for (int i = 0; i < 10; i++) {
            String randomEnglish = englishList.get((int) (Math.random() * 10));
            System.out.println(randomEnglish);
        }
    }
}
