import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListList {


    public static void main(String[] args) {

        List<String> pocker = new ArrayList<>(Arrays.asList("A"));

        int[] cardNumbers = {2,3,4,5,6,7,8,9};
        int cardNumbersLength = cardNumbers.length;



        for(int i = 0; i < cardNumbersLength; i++) {
            pocker.add(String.valueOf(cardNumbers[i]));

        }
        pocker.add(("J"));
        pocker.add(("Q"));
        pocker.add(("K"));

        System.out.println(pocker);
    }
}
