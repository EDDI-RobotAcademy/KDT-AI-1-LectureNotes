package playdice;

// 주사위 게임 내에 사람도 필요하고 룰도 필요하고

public enum DiceEnumSet {
    PLAYER_1("하나"),
    PLAYER_2("둘");

    final private String name;

    DiceEnumSet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


