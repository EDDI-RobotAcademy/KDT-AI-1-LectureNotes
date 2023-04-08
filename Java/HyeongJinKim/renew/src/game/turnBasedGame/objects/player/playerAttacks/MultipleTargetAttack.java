package game.turnBasedGame.objects.player.playerAttacks;

import utility.random.CustomRandom2;

public class MultipleTargetAttack {
    private static double multipleTargetAttackDMG;
    private double min;
    private double max;
    private static boolean critical = false;
    final private int HUNDREDTH = 99;
    final private double CORRECTION_VALUE = 6 / 10;
    final private double CRITICAL_VALUE = 1.3;

    public MultipleTargetAttack(double strength, double dexterity, double intelligence) {
        this.min = strength * CORRECTION_VALUE;
        this.max = strength * (1.8 - CORRECTION_VALUE);
        if (CustomRandom2.generateNumber(0, HUNDREDTH) <= dexterity) {
            this.critical = true;
        }
        else {
            this.critical = false;
        }
        if (this.critical) {
            this.multipleTargetAttackDMG =
                    CustomRandom2.generateNumber(min * CRITICAL_VALUE, max * CRITICAL_VALUE) + intelligence;
        }
        else {
            this.multipleTargetAttackDMG =
                    CustomRandom2.generateNumber(min, max) + intelligence;
        }
    }

    public static double getMultipleTargetAttackDMG() {
        return multipleTargetAttackDMG;
    }

    public static boolean isCritical() {
        return critical;
    }

    @Override
    public String toString() {
        return "MultipleTargetAttack{" +
                "multipleTargetAttackDMG=" + multipleTargetAttackDMG +
                ", min=" + min +
                ", max=" + max +
                ", critical=" + critical +
                ", HUNDREDTH=" + HUNDREDTH +
                ", CORRECTION_VALUE=" + CORRECTION_VALUE +
                ", CRITICAL_VALUE=" + CRITICAL_VALUE +
                '}';
    }
}
