package Enum;

public enum Pattern {
    // enum의  선언.
    // enum 별명 { 변수명1, 변수명2, …) 이렇게 해준다.
    ABCD("첫 번째 패턴", 1),
    EFG("두 번째 패턴", 2),
    HIJK("세 번째 패턴", 3),
    LMNOP("네 번째 패턴", 4),
    QRS("다섯 번째 패턴", 5),
    TUV("여섯 번째 패턴", 6),
    WXYZ("일곱 번째 패턴", 7);

    final private String name;
    final private int value;

    // 생성자.
    Pattern(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // getter
    public String getName() { // getter
        return name;
    }

    public int getValue() {
        return value;
    }

}
