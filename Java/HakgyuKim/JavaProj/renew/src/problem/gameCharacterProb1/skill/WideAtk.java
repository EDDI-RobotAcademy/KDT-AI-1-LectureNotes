package problem.gameCharacterProb1.skill;

import utility.random.CustomRandom;

public class WideAtk {
    final private int SkillDamage;
    private int MIN = 2;
    private int MAX = 5;

    public WideAtk (int min, int max) {
        this.MIN = min + MIN;
        this.MAX = max + MAX;
        this.SkillDamage = CustomRandom.generateNumber(MIN, MAX);
    }

    public int getSkillDamage() {
        return SkillDamage;
    }

    @Override
    public String toString() {
        return "WideAtk{" +
                "SkillDamage=" + SkillDamage +
                '}';
    }
}
