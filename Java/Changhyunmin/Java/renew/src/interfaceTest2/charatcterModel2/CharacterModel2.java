package interfaceTest2.charatcterModel2;

import interfaceTest2.Status2;

public class CharacterModel2 {
    private int strength;
    private int intelligent;
    private int dexterity;
    private int agility;
    private int hp;
    private Status2 status2;
    public CharacterModel2(int strength, int intelligent, int dexterity, int agility, int hp) {
        this.strength = strength;
        this.intelligent = intelligent;
        this.dexterity = dexterity;
        this.agility = agility;
        this.hp = hp;
    }

    public CharacterModel2(Status2 status2) {
        this.status2 = status2.NORMAL;
    }

    public Status2 getStatus2() {
        return status2;
    }

    public void setStatus2(Status2 status2) {
        this.status2 = status2;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void calculateDamage (int damage){
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
    public Boolean decisionDeath(){
        if (getHp() <= 0){
            setStatus2(Status2.DEATH);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CharacterModel2{" +
                "strength=" + strength +
                ", intelligent=" + intelligent +
                ", dexterity=" + dexterity +
                ", agility=" + agility +
                ", hp=" + hp +
                ", status2=" + status2 +
                '}'+'\n';
    }
}
