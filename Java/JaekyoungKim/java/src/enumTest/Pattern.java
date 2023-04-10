package enumTest;

public enum Pattern {
    A("A",1),
    B("B",2),
    C("C",3),
    D("D",4),
    E("E",5),
    F("F",6),
    G("G",7);
    final private String name;
    final private int value;
    private Pattern (String name,int value){
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
