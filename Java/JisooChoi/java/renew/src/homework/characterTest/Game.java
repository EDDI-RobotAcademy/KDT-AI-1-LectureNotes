package homework.characterTest;

import java.util.ArrayList;

public class Game {
    final private Character character = new Character(20, 20, 20, "chen");
    final private ArrayList<Monster> monsterList = new ArrayList<>();
    final private Monster yoda = new Monster(10, 10, 10, "yoda");
    final private Monster gollum = new Monster(10, 10, 10, "gollum");

    public Game() {
        monsterList.add(yoda);
        monsterList.add(gollum);
    }

    public void fightGame() {
        int randomNum = (int)(Math.random() * monsterList.size());

        while((character.healthPoint > 0) && (monsterList.get(0).healthPoint > 0)
                && (monsterList.get(1).healthPoint > 0)){
            if((character.healthPoint < monsterList.get(randomNum).healthPoint)){
                // 몬스터 공격
                monsterList.get(randomNum).monsterComboAttack(character);
                // 캐릭터 공격
                character.singleAttack(monsterList.get(randomNum));
                System.out.println();
            }
            else{
                // 몬스터 공격
                monsterList.get(randomNum).monsterAttack(character);
                // 캐릭터 공격
                character.largeAttack(monsterList.get(0), monsterList.get(1));
                System.out.println();
            }
        }
        System.out.println("--> 0이 나왔으므로 종료합니다.");
    }
}
