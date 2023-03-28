package homework.enumTest;

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
    PATTERN_J("J", 10),
    PATTERN_Q("Q", 11),
    PATTERN_K("K", 12);

    static CardPattern[] patternValueList = CardPattern.values(); //patternValueList는 CardPattern(name, value)를 나열한 배열
    String cardName;
    int value;

    private CardPattern (String cardName, int value) {
        this.cardName = cardName;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getCardName() {
        return cardName;
    }

    public static CardPattern patternName(int num) {
        return
        patternValueList[num];
    }

    @Override
    public String toString() {
        return "CardPattern{" +
                "name='" + cardName + '\'' +
                ", value=" + value +
                '}';
    }
}
