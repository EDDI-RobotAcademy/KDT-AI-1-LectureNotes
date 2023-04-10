package game.turnBasedGame.objects.player.playerAttacks;

import utility.random.CustomRandom2;

public class Attack {
    private static double attackDMG;
    private double min;
    private double max;
    private static boolean critical = false;
    final private int HUNDREDTH = 99;
    final double CORRECTION_VALUE = 5 / 10;
    final double CRITICAL_VALUE = 1.2;

    public Attack(double strength, double dexterity) {
        this.min = strength * CORRECTION_VALUE;
        this.max = strength;
        if (CustomRandom2.generateNumber(0, HUNDREDTH) <= dexterity) {
            this.critical = true;
        }
        else {
            this.critical = false;
        }
        if (this.critical) {
            this.attackDMG =
                    CustomRandom2.generateNumber(min * CRITICAL_VALUE, max * CRITICAL_VALUE);
        }
        else {
            this.attackDMG =
                    CustomRandom2.generateNumber(min, max);
        }
    }
    public static double getAttackDMG() {
        return attackDMG;
    }

    public static boolean isCritical() {
        return critical;
    }

    @Override
    public String toString() {
        return "Attack{" +
                "attackDMG=" + attackDMG +
                ", min=" + min +
                ", max=" + max +
                ", critical=" + critical +
                ", HUNDREDTH=" + HUNDREDTH +
                ", CORRECTION_VALUE=" + CORRECTION_VALUE +
                ", CRITICAL_VALUE=" + CRITICAL_VALUE +
                '}';
    }
}