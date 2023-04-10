package game.rpg.characterModel;

import utility.random.CustomRandom;

public class CharacterModel {
    private int strength;       // 완력
    private int intelligent;    // 지능
    private int dexterity;      // 재주
    private int agility;        // 민첩
    private int hp;             // hp
    private int status;         // 상태
    private final int DEATH = -777;
    private final int NORMAL = 1;

    public CharacterModel(int strength, int intelligent, int dexterity, int agility, int hp) {
        this.strength = strength;
        this.intelligent = intelligent;
        this.dexterity = dexterity;
        this.agility = agility;
        this.hp = hp;

        this.status = NORMAL;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CharacterModel{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                ", status=" + status +
                '}' + '\n';
    }
}
