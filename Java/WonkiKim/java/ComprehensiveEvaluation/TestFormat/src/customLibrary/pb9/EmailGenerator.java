package customLibrary.pb9;

import customLibrary.math.RandomGenerator;

public class EmailGenerator {
    private int numberOfCharacter;
    final private int MIN_NUMBER_OF_CHARACTER = 5;
    final private int MAX_NUMBER_OF_CHARACTER = 10;
    final private int SMALL_ALPHABET_START = 97;
    final private int SMALL_ALPHABET_END = 122;
    final private int CAPITAL_ALPHABET_START = 65;
    final private int CAPITAL_ALPHABET_END = 90;
    final private int NUMBER_START = 48;
    final private int NUMBER_END = 57;
    final private String DOMAIN = "@test.com";

    public String emailGenerate() {
        String tmpEmail = "";
        RandomGenerator randomGenerator = new RandomGenerator();
        numberOfCharacter = randomGenerator.randomInt(MIN_NUMBER_OF_CHARACTER, MAX_NUMBER_OF_CHARACTER);
        for (int i = 0; i < numberOfCharacter; i++) {
            final int SMALL_LETTER = 0;
            final int CAPITAL_LETTER = 1;
            final int NUMBER_LETTER = 2;
            final int CASE = randomGenerator.randomInt(SMALL_LETTER, NUMBER_LETTER);
            switch (CASE) {
                case SMALL_LETTER ->
                        tmpEmail += (char) randomGenerator.randomInt(SMALL_ALPHABET_START, SMALL_ALPHABET_END);
                case CAPITAL_LETTER ->
                        tmpEmail += (char) randomGenerator.randomInt(CAPITAL_ALPHABET_START, CAPITAL_ALPHABET_END);
                case NUMBER_LETTER -> tmpEmail += (char) randomGenerator.randomInt(NUMBER_START, NUMBER_END);
            }

        }

        tmpEmail += DOMAIN;
        return tmpEmail;
    }
}
