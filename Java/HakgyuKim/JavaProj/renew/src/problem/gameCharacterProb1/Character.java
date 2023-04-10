package problem.gameCharacterProb1;

import problem.gameCharacterProb1.enemy.Enemy;
import problem.gameCharacterProb1.enemy.EnemyModel;
import problem.gameCharacterProb1.enemy.EnemyNormalAtk;
import problem.gameCharacterProb1.skill.NormalAtk;
import problem.gameCharacterProb1.skill.WideAtk;

import java.util.List;

public class Character {
    final private String name;
    private int health;
    private int strength;
    private int dexterity;
    private int talent;
    private int intelligence;

    final private NormalAtk normalAtkSkill;
    final private WideAtk wideAtkSkill;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.strength = 10;
        this.dexterity = 10;
        this.talent = 10;
        this.intelligence = 10;

        this.normalAtkSkill = new NormalAtk(dexterity/2, strength/2);
        this.wideAtkSkill  = new WideAtk(intelligence/2, talent/2);
    }

    public NormalAtk getNormalAtkSkill() {
        return normalAtkSkill;
    }

    public WideAtk getWideAtkSkill() {
        return wideAtkSkill;
    }

    public void characterNormalAtk (Enemy enemy, int normalAtkSkill) {
        enemy.setHealth(enemy.getHealth() - normalAtkSkill);
    }

    public void characterWideAtk (List<Enemy> enemyList, int wideAtkSkill) {
        for (int i = 0; i < enemyList.size(); i++) {
           enemyList.get(i).setHealth(enemyList.get(i).getHealth() - wideAtkSkill);
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
}
