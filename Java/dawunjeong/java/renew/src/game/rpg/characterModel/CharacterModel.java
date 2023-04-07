package game.rpg.characterModel;

import utility.random.CustomRandom;

public class CharacterModel {
    private int strength;       // 완력
    private int intelligent;    // 지능
    private int dexterity;      // 재주
    private int agility;        // 민첩
    private int hp;             // hp
    private Status status;         // 상태

    public CharacterModel(int strength, int intelligent, int dexterity, int agility, int hp) {
        this.strength = strength;
        this.intelligent = intelligent;
        this.dexterity = dexterity;
        this.agility = agility;
        this.hp = hp;

        this.status = Status.NORMAL;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void calculateDamage (int damage) {
        hp -= damage;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligent() {
        return intelligent;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public Boolean decisionDeath() {
        if (getHp() <= 0) {
            setStatus(Status.DEATH);
            return true;
        }

        return false;
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