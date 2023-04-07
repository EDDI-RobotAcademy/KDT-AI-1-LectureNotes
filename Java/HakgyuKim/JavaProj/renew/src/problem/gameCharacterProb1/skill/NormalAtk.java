package problem.gameCharacterProb1.skill;

import utility.random.CustomRandom;

public class NormalAtk {
    final private int SkillDamage;
    private int MIN = 5;
    private int MAX = 10;

    public NormalAtk (int min, int max) {
        this.MIN = min + MIN;
        this.MAX = max + MAX;
        this.SkillDamage = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getSkillDamage() {
        return SkillDamage;
    }

    @Override
    public String toString() {
        return "NormalAtk{" +
                "SkillDamage=" + SkillDamage +
                '}';
    }
}
