package homework.fifth.review;

public enum CardPattern {
    PATTERN_A("A", 1),
    PATTERN_2("2", 2),
    PATTERN_3("3", 3),
    PATTERN_4("4", 4),
    PATTERN_5("5", 5),
    PATTERN_6("6", 6),
    PATTERN_7("7", 7),
    PATTERN_8("8", 8),
    PATTERN_9("9", 9),
    PATTERN_10("10", 10),
    PATTERN_J("J", 11),
    PATTERN_Q("Q", 12),
    PATTERN_K("K", 13);

    public static final CardPattern[] patterns = CardPattern.values();
    final private String name;
    final private int value;

    private CardPattern (String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static CardPattern checkPatternByIndex (int index) {
        return patterns[index];
    }

    public static String chk(int idx) {return patterns[idx].getName();}

    @Override
    public String toString() {
        return "CardPattern{" +
                "name='" + name + '\'' +
                '}';
    }
}