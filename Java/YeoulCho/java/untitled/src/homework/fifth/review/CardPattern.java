package homework.fifth.review;

public enum CardPattern { //class가 enum(열거형, 목록)
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


    public static CardPattern[] patterns = CardPattern.values();
    //cardPatterns 배열 pattern은 cardPattern 목록전부?
    final String name;
    final int value;

    private CardPattern(String name, int value) { //왜 public이 안될까?
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public static CardPattern checkPatternByIndex(int index){
        //checkPatternByIndex ( int index) 넣으면
        // static 을 써야 클래스에서 사용가능 객체를 생성하지 않아도 사용가능
        return patterns[index]; //patterns(배열)의 index
    }

    @Override
    public String toString() {
        return "CardPattern{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}'
                ;
    }
}
