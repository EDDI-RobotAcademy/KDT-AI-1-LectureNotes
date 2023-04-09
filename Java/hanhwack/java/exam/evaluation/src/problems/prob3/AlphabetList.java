package problems.prob3;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class AlphabetList {
    private List<Character> alphabetList = new ArrayList<>();

    public AlphabetList() {
        for (int i= 65; i < 75; i++) {
            alphabetList.add((char)i);
        }
    }

    public void getRandomAlphabet() {
        int i = CustomRandom.generateNumber(9);
        System.out.println(alphabetList.get(i));

    }


}
