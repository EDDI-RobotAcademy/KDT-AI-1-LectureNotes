package problems.prob3;

import customLibrary.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class AlphabetList {

    private List<String> alphabetList = new ArrayList<>();

    public AlphabetList() {
        alphabetList.add("A");
        alphabetList.add("B");
        alphabetList.add("C");
        alphabetList.add("D");
        alphabetList.add("E");
        alphabetList.add("F");
        alphabetList.add("G");
        alphabetList.add("H");
        alphabetList.add("I");
        alphabetList.add("J");
    }
    public void getRandomAlphabet() {
        int randomAlphabetIdx = CustomRandom.generateNumber(alphabetList.size());
        System.out.println(alphabetList.get(randomAlphabetIdx));
    }
}
