package problems.prob3;

import customLibrary.utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    private static void printRandomCharacterList(List<Character> characterList) {
        final int LIST_BIAS = 1;

        final int LOOP_NUMBER = 5;
        for (int i = 0; i < LOOP_NUMBER; i++) {
            final int randomIndex =
                    CustomRandom.generateNumber(
                            characterList.size() - LIST_BIAS);

            System.out.println(characterList.get(randomIndex));
        }
    }
    public static void main(String[] args) {
        char storeCharacter = 'A';
        final List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            characterList.add((char) (storeCharacter + i));
        }

        printRandomCharacterList(characterList);
    }
}
