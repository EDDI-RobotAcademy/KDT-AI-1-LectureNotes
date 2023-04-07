package rewiew.march23_Dice3_Review;

public class Player_Review {
    // Player를 만들었으면 여기에만 집중
    // player 이름
    // player 2명이라고 했음 - main에서

    private final String name;

    public Player_Review(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return " 주사위 게임 {" +
                "name='" + name + '\'' +
                '}';
    }
}
