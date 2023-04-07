package homework.character;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import utility.random.CustomRandom;
import utility.generator.SequenceGenerator;

public class GameManager {

    final List<Monster> monsterList = new ArrayList<>();
    final Character character = new Character(0);

    // 몬스터 랜덤 생성
    public void addMonster(int MONSTER_NUM) {

        for (int i = 0; i < MONSTER_NUM; i++) {
            monsterList.add(new Monster(SequenceGenerator.getSpecificEntityId("몬스터")));
        }
    }

    // 몬스터 리스트 출력(Id와 HP 포함)
    public void printMonsterList() {
        for (Monster monster: monsterList) {
            System.out.println(monster);
        }
    }

    // 공격 스킬
    public void playGame() {
        // 캐릭터 스킬 데미지
        final int monsterAttackSkill1_damage = 30;
        final int monsterAttackSkill2_damage = 20;

        // 몬스터 스킬 데미지
        final int charactorAttackSkill_damage = 15;

        Scanner scan = new Scanner(System.in);
        StatusHP charactorHP;

        // 캐릭터의 현재 HP가 0 이상인가 ?
        boolean checkHP = character.getcharacterHP().getcurrentHP() > 0;

        // 캐릭터의 현재 HP가 0 이상이면 수행
        while(checkHP) {
            if(character.getcharacterHP().getcurrentHP() > 0){
                System.out.println("공격 스킬을 선택하세요. 단일공격 : 1, 광역공격 : 2");

                int skillNumber = scan.nextInt();

                switch(skillNumber) {

                    // 단일공격
                    case 1:
                        System.out.println("공격 대상을 선택하세요. 몬스터0 : 0, 몬스터1 : 1");
                        int targetmonsterIndex = scan.nextInt();

                        // 몬스터의 Id에 해당하는 숫자를 입력했을 때 수행하고,
                        // 이외의 숫자를 입력하면 다시 입력하도록 함
                        if(targetmonsterIndex < monsterList.size()) {

                            // 타켓이 되는 몬스터에게 공격
                            StatusHP targetresultHP = monsterList.get(targetmonsterIndex).getStatusHP();
                            targetresultHP.monsterAttackSkill1(targetresultHP, monsterAttackSkill1_damage);
                            System.out.println("몬스터" + targetmonsterIndex + "의 HP: " + targetresultHP.getcurrentHP());

                            // 몬스터 공격시 몬스터도 맞대응
                            charactorHP = character.getcharacterHP();
                            charactorHP.charactorAttackSkill(charactorHP, charactorAttackSkill_damage);
                            System.out.println("캐릭터" + character.characterId +"의 HP: "+ charactorHP.getcurrentHP());

                        }
                        // System.out.println("다시 입력하세요");
                        break;

                    // 광역공격
                    case 2:
                        // 몬스터의 수만큼 반복하도록 함
                        for(int i = 0; i < monsterList.size(); i++) {

                            StatusHP targetresultHP2 = monsterList.get(i).getStatusHP();
                            targetresultHP2.monsterAttackSkill2(targetresultHP2, monsterAttackSkill2_damage);
                            System.out.println("몬스터" + i + "의 HP: " + targetresultHP2.getcurrentHP());

                        }

                        // 몬스터의 맞대응
                        for(int j = 0; j < monsterList.size(); j++) {
                            charactorHP = character.getcharacterHP();

                            charactorHP.charactorAttackSkill(charactorHP, charactorAttackSkill_damage);
                            System.out.println("캐릭터" + character.characterId +"의 HP: "+ charactorHP.getcurrentHP());

                        }
                        break;
                }
            }
        }
    }

    // 현재 캐릭터와 몬스터의 HP 출력
    public void printcurrentHP() {
        System.out.println("캐릭터 HP: " + character.getHP());

        for(int i = 0; i < 2; i ++) {
            System.out.println("몬스터" + monsterList.get(i).monsterId
                    + "의 HP: " + monsterList.get(i).getHP());
        }

    }
}
