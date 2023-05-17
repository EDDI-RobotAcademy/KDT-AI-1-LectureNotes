package interfaceTest.refactor;

import random.CustomRandom;

public class CharacterModel {
    private int strength; //완력
    private int intelligent; //지능
    private int dexterity; //재주
    private int agility; //민첩
    private int HP;
    private Status status;

    public CharacterModel(int strength, int intelligent, int dexterity, int agility, int HP) {
        this.strength = strength;
        this.intelligent = intelligent;
        this.dexterity = dexterity;
        this.agility = agility;
        this.HP = HP;
        this.status = Status.NOMAL;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void calculateDamage (int damage) {
        HP -= damage;
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
    public Boolean decisionDeath(){
        if (getHP() <= 0) {
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
                ", HP=" + HP +
                '}';
    }
}
