package problems.prob3;

import customLibrary.customRandom.CustomRandom;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

class Alphabet {
    List<Character> alphabetList = new ArrayList<>();
    private char randomizeAlphabet;
//    private String aToJ;
    public Alphabet () {
        for (char i = 'a'; i <= 'j'; i++) {
           alphabetList.add(i);
            }
    }
    public char randomAlphabet () {
        return randomizeAlphabet = alphabetList.get(CustomRandom.generateNumber('a', 'j'));
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "alphabetList=" + alphabetList +
                '}';
    }
}

    public class Problem3 {
    public static void main(String[] args) {
        Alphabet alphabet = new Alphabet();
        System.out.println(alphabet);
        System.out.println(alphabet.randomAlphabet());

    }
}
