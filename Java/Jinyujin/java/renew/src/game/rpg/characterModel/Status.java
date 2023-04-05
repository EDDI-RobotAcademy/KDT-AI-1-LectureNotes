package game.rpg.characterModel;

// 캐릭터나 몬스터가 죽었는지 안죽었는지의 상태를 알아보기 위한 enum
public enum Status {
    NORMAL ("정상", 1),
    DEATH ("죽음", -999);

    final private String name;
    final private int value;

    Status(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // 가져가서 쓸 꺼니까 둘 다 getter 추가
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
