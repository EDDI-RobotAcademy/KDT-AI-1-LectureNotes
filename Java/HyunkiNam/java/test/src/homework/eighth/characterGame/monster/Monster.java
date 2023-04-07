package homework.eighth.characterGame.monster;

import homework.eighth.characterGame.player.Player;

public class Monster {
    final String name;
    int HP;
    final int Attack;
    final int EXP;

    public Monster(String name){
        this.name = name;
        this.HP = 30;
        this.Attack = 3;
        this.EXP = 120;
    }

    public void monsterAttack(Player player){
        player.setHP(player.getHP()-Attack);
    }
    public String getName() {
        return name;
    }
    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        this.HP = HP;
    }
    public int getAttack() {
        return Attack;
    }
    public int getEXP() {
        return EXP;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", HP=" + HP +
                ", Attack=" + Attack;
    }
}
