package homework.seventh;

import utilityRandom.CustomRandom;

import java.sql.Array;

public class Fight {
    Character character= new Character();
    Monster monsterA =new Monster();
    Monster monsterB =new Monster();
    Monster[] monsterArray= {monsterA,monsterB};


    public Fight() {

    }

    void playerAtack(){  //플레이어가 공격하는 경우

        int attackNum= CustomRandom.generateNumber(1,3);// 3개의 공격중 어떤 공격을 할지 랜덤으로 정해짐
        int attackMonster=CustomRandom.generateNumber(0,1);// 일반 공격과 헤드샷중 어떠 몬스터에 공격할지 정하는 것
        switch (attackNum){
            case 1: character.attack(monsterArray[attackMonster]); // 일반 공격
            break;
            case 2: character.doubleAttack(monsterArray[0]);// 다중공격
                character.doubleAttack(monsterArray[1]);
            break;
            case 3: character.headShot(monsterArray[attackMonster]); // 헤드샷
        }


    }
    void monsterAttack(){
        monsterA.attck(character);// 몬스터가 공격하는 경우
        monsterB.attck(character);

    }
    public void battle() {

        character.showInfo();// 각 플레이어와 몬스터의 상태를 보여준다.
        monsterA.showInfo();
        monsterB.showInfo();
        while ((character.hp>0)&&(monsterA.hp*monsterB.hp> 0)){
            // 캐릭터의 체력이 0보다 높고
            // 몬스터들의 체력이 0보다 높은경우에 서로 공격하는 것을 반복
            playerAtack();
            System.out.println("");
            monsterAttack();
            System.out.println("");
            System.out.println(character.name + ": " + character.hp + "  " + monsterA.name
                    + ": " + monsterA.hp+"  "+monsterB.name+": "+monsterB.hp);// 공격 후 체력 남은량 보여줌
            System.out.println("");
        }
        if (character.hp < monsterA.hp) {
            System.out.println(monsterA.name + "의 승리 입니다.");
        }
        if (character.hp > monsterA.hp) {
            System.out.println(character.name + "의 승리 입니다.");

        }
    }}


