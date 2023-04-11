package problems.prob3;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static void main(String[] args) {
        List<String> alphabetList = new ArrayList<>();
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

        int firstAlphabetIDX = 0;
        int lastAlphabetIDX = 9;

        int randomNumber = CustomRandom.generateNumber(firstAlphabetIDX,lastAlphabetIDX);
        System.out.println(alphabetList);
        System.out.println(alphabetList.get(randomNumber));



        }


    }

