package problems.prob3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem3 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");
        strings.add("E");
        strings.add("F");
        strings.add("G");
        strings.add("H");
        strings.add("I");
        strings.add("J");

        Random random = new Random();
        String random1 = strings.get(random.nextInt(strings.size()));

        System.out.println(random1);

    }
}
