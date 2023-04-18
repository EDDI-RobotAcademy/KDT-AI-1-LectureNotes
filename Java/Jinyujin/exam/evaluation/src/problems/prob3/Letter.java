package problems.prob3;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Letter {
    final private List<String> letterList = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

    public void printRandomLetter() {
        Random random = new Random();
        int randomIndex = random.nextInt(letterList.size());
        String printMe = letterList.get(randomIndex);

        System.out.println(printMe);
    }
}

