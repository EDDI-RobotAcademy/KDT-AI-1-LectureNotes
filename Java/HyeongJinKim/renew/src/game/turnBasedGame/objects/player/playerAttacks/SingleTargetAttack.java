package game.turnBasedGame.objects.player.playerAttacks;

import utility.random.CustomRandom2;

public class SingleTargetAttack {
    private static double singleTargetAttackDMG;
    private double min;
    private double max;
    private static boolean critical = false;
    final private int HUNDREDTH = 99;
    final double CORRECTION_VALUE = 8 / 10;
    final double CRITICAL_VALUE = 1.5;

    public SingleTargetAttack(double strength, double dexterity, double intelligence) {
        this.min = strength * CORRECTION_VALUE;
        this.max = strength * (2 - CORRECTION_VALUE);
        if (CustomRandom2.generateNumber(0, HUNDREDTH) <= (dexterity * 2)) {
            this.critical = true;
        }
        else {
            this.critical = false;
        }
        if (this.critical) {
            this.singleTargetAttackDMG =
                    CustomRandom2.generateNumber(min * CRITICAL_VALUE, max * CRITICAL_VALUE) + intelligence;
        }
        else {
            this.singleTargetAttackDMG =
                    CustomRandom2.generateNumber(min, max) + intelligence;
        }
    }

    public static double getSingleTargetAttackDMG() {
        return singleTargetAttackDMG;
    }

    public static boolean isCritical() {
        return critical;
    }

    @Override
    public String toString() {
        return "SingleTargetAttack{" +
                "singleTargetAttackDMG=" + singleTargetAttackDMG +
                ", min=" + min +
                ", max=" + max +
                ", critical=" + critical +
                ", HUNDREDTH=" + HUNDREDTH +
                ", CORRECTION_VALUE=" + CORRECTION_VALUE +
                ", CRITICAL_VALUE=" + CRITICAL_VALUE +
                '}';
    }
}
