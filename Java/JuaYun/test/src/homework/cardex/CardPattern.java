package homework.cardex;

public enum CardPattern {   // 모든 패턴을 배열화시켜 저장하는 작업 CustomRandom과 동일한 목적
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

    // 언제나 패턴에서 뽑아서 쓸 수 있게 만들기 위해서 만든 코드
    public static CardPattern[] patterns = CardPattern.values();
    final private String name;
    final private int value;

    // 생성자
    private CardPattern(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 외부에서 내부에 있는 정보를 뽑아서 사용할 것이기 때문에 getter를 만듬
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
    // public static CardPattern[] patterns = CardPattern.values();
    // 이 코드를 통해 배열에 박힌 값을 index에 따라 뽑아내는 작업
    public static CardPattern checkPatternByIndex (int index) {
        return patterns[index];
    }

    @Override
    public String toString() {
        return "CardPattern{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
