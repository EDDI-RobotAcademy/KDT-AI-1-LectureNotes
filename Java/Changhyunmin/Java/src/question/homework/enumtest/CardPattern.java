package question.homework.enumtest;

import question.homework.Player;

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

    public static CardPattern[] patterns = CardPattern.values();
    final private String Name;
    final private int Values;

    private CardPattern (String Name, int Values){
        this.Name = Name;
        this.Values = Values;
    }

    public String getName() {
        return Name;
    }

    public int getValues() {
        return Values;
    }
    public static CardPattern checkPatternByIndex (int index) {
        return patterns[index];
    }

    @Override
    public String toString() {
        return "CardPattern{" +
                "Name='" + Name +
                ", Values=" + Values + '\n';
    }
}
