package homework.seventh;

import utilityRandom.CustomRandom;

public class Fight {
    Character character= new Character();
    Monster monster =new Monster();

    public Fight() {
        this.character = character;
        this.monster = monster;
    }

    void playerAtack(){
        int attackNum= CustomRandom.generateNumber(1,3);
        switch (attackNum){
            case 1: character.attack(monster);
            break;
            case 2: character.doubleAttack(monster);
            break;
            case 3: character.headShot(monster);
        }


    }
    void monsterAttack(){
        monster.attck(character);
    }
    public void battle() {
        character.showInfo();
        monster.showInfo();
        while (character.hp * monster.hp >= 0) {
            playerAtack();
            System.out.println("");
            monsterAttack();
            System.out.println("");
            System.out.println(character.name + "의 남은 체력: " + character.hp + "  " + monster.name + "의 남은 체력: " + monster.hp);
            System.out.println("");
        }
        if (character.hp < monster.hp) {
            System.out.println(monster.name + "의 승리 입니다.");
        }
        if (character.hp > monster.hp) {
            System.out.println(character.name + "의 승리 입니다.");

        }
    }}


