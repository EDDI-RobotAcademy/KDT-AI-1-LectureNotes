package enumTest;

public enum Pattern2 {
    ABCD("첫 번째 패턴",1,2),
    EFG("두 번째 패턴",3,4);
    private final String name;
    private final int value;
    private final int value2;

    private Pattern2(String name, int value, int value2){
        this.name = name;
        this.value = value;
        this.value2 = value2;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }
}
