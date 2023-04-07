package homework.listTestRefactor;

public enum CardPattern {
    CARD_A("A", 1),
    CARD_2("2", 2),
    CARD_3("3", 3),
    CARD_4("4", 4),
    CARD_5("5", 5),
    CARD_6("6", 6),
    CARD_7("7", 7),
    CARD_8("8", 8),
    CARD_9("9", 9),
    CARD_10("10", 10),
    CARD_J("J", 11),
    CARD_Q("Q", 12),
    CARD_K("K", 13);


    public static CardPattern[] patterns = CardPattern.values();
    final private String name;
    final private int value;

    CardPattern(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String checkPatternByIndex(int i) {
        return String.valueOf(patterns[i]);
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }
}
