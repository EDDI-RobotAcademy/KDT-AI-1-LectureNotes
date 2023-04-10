package game.turnBasedGame.objects.player;

import game.turnBasedGame.objects.monster.Monster;
import game.turnBasedGame.objects.player.playerAttacks.Attack;
import game.turnBasedGame.objects.player.playerAttacks.MultipleTargetAttack;
import game.turnBasedGame.objects.player.playerAttacks.SingleTargetAttack;

import java.util.List;

public class PlayerInfo {
    private static int healthPoint;
    private int strength;
    private int agility;
    private int dexterity;
    private int intelligence;

    /* TODO: 뭔가 이상함 */
    final private Attack attack;
    final private SingleTargetAttack singleTargetAttack;
    final private MultipleTargetAttack multipleTargetAttack;

    public PlayerInfo() {
        this.healthPoint = 100;
        this.strength = 10;
        this.agility = 20;
        this.dexterity = 8;
        this.intelligence = 10;
        this.attack = new Attack(strength, dexterity);
        this.singleTargetAttack = new SingleTargetAttack(strength, dexterity, intelligence);
        this.multipleTargetAttack = new MultipleTargetAttack(strength, dexterity, intelligence);
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void playerAttack (Monster monster, int attack) {
        monster.setHealthPoint(monster.getHealthPoint() - attack);
    }

    public void playerSingleSkill (Monster monster, int singleTargetAttack) {
        monster.setHealthPoint(monster.getHealthPoint() - singleTargetAttack);
    }

    public void playerMultipleSkill (List<Monster> monsterList, List<Integer> mulipleDMGList) {
        for (int i = 0; i < monsterList.size(); i++) {
            monsterList.get(i).setHealthPoint(monsterList.get(i).getHealthPoint() - mulipleDMGList.get(i));
        }
    }

    public static int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }
}
