package homework.eighth.characterGame.player;

public class PlayerSkill {
    int singleTargetDamage;
    int multipleTargetDamage;

    public PlayerSkill(){
        this.singleTargetDamage = 10;
        this.multipleTargetDamage = 6;
    }

    public int getSingleTargetDamage() {
        return singleTargetDamage;
    }

    public int getMultipleTargetDamage() {
        return multipleTargetDamage;
    }

    @Override
    public String toString() {
        return "singleTargetDamage=" + singleTargetDamage +
                ", multipleTargetDamage=" + multipleTargetDamage;
    }
}
