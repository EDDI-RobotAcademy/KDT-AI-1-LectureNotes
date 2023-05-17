package homework.fifth.review.strange;

public enum CardPattern2 {
    PATTERN_A("A", 1),
    PATTERN_2("2", 2),
    PATTERN_3("3", 3),
    PATTERN_4("4", 4),
    PATTERN_5("5", 5),
    PATTERN_6("6", 6),
    PATTERN_7("7", 7),
    PATTERN_8("8", 8),
    PATTERN_9("9", 9),
    PATTERN_J("J", 10),
    PATTERN_Q("Q", 11),
    PATTERN_K("K", 12);

    final private String name;
    final private int value;

    private CardPattern2 (String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CardPattern{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
