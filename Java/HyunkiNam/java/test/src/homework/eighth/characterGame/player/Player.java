package homework.eighth.characterGame.player;

import homework.eighth.characterGame.monster.Monster;

import java.util.List;

public class Player {
    int level, MAX_HP, MAX_MP, HP, MP, Attack;
    int STR, DEX, TACT, INT;
    int exp;
    PlayerSkill playerSkill = new PlayerSkill();

    public Player(){
        this.level = 1;
        this.exp = 0;
        this.MAX_HP = 50;
        this.HP = MAX_HP;
        this.MAX_MP = 30;
        this.MP = MAX_MP;
        this.STR = 10;
        this.Attack = STR/2;
        this.DEX = 10;
        this.TACT = 10;
        this.INT = 10;
        this.playerSkill.singleTargetDamage = INT;
        this.playerSkill.multipleTargetDamage = INT/2 + 1;
    }

    public void playerAttack(Monster monster){
        monster.setHP(monster.getHP()-this.Attack);
        System.out.println(monster.getName() + "에게 일반 공격을 시전했습니다.");
        System.out.println(this.Attack + "의 데미지를 입혔습니다.");
    }

    public PlayerSkill getPlayerSkill() {
        return playerSkill;
    }

    public void playerSingleAttack(Monster monster, int singleTargetDamage) {
        this.MP -= 5;
        monster.setHP(monster.getHP()- singleTargetDamage);
        System.out.println(monster.getName() + "에게 단일 공격을 시전했습니다.");
        System.out.println(singleTargetDamage + "의 데미지를 입혔습니다.");
    }

    public void playerMultipleAttack(List<Monster> monsterList, int multipleTargetDamage) {
        this.MP -= 10;
        for (Monster TargetMonster : monsterList) {
            TargetMonster.setHP(TargetMonster.getHP() - multipleTargetDamage);
        }
        System.out.println("광역 공격을 시전했습니다.");
        System.out.println(multipleTargetDamage + "의 데미지를 입혔습니다.");
    }

    public void getEXP(int exp){
        System.out.println(exp + "의 경험치를 얻었습니다");
        this.exp += exp;
        if(this.exp >= 100){
            System.out.println("Level Up !");
            levelUp();
        }
    }

    private void levelUp(){
        this.exp -= 100;
        this.level += 1;
        this.MAX_HP += 10;
        this.MAX_MP += 5;
        this.HP = MAX_HP;
        this.MP = MAX_MP;
        this.STR += 3;
        this.Attack = STR/2;
        this.DEX += 3;
        this.TACT += 3;
        this.INT += 3;
        this.playerSkill.singleTargetDamage = INT;
        this.playerSkill.multipleTargetDamage = INT/2 + 1;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }


    @Override
    public String toString() {
        return "Player{" +
                "level=" + level +
                ", HP=" + HP +
                ", MP=" + MP +
                ", Attack=" + Attack +
                ", STR=" + STR +
                ", DEX=" + DEX +
                ", TACT=" + TACT +
                ", INT=" + INT +
                ", exp=" + exp +
                ", playerSkill=" + playerSkill +
                '}';
    }
}
