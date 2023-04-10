package problems.prob3;
/// “A”, “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “J” 문자열 10개 리스트 랜덤 출력
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class Problem3 {
    public static void main(String[] args) {
        List<String> textList
                = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

        Random random = new Random();
        int randomIndex = random.nextInt(textList.size());
        System.out.println(textList.get(randomIndex));
        
    }
}
