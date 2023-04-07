package homework.eighth.characterGame;

import homework.eighth.characterGame.monster.Monster;
import homework.eighth.characterGame.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharGameManager {
    final int MAX_MONSTER_NUM = 2;
    Player player;
    List<Monster> monsterList = new ArrayList<>();

    public CharGameManager(){
        player = new Player();
        for(int i=0; i<MAX_MONSTER_NUM; i++){
            monsterList.add(new Monster("Monster"+(i+1)));
        }
    }

    public void play(){
        boolean monsterCheckLive = true;
        boolean playerCheckLive = true;

        while(monsterCheckLive && playerCheckLive){
            Scanner sc = new Scanner(System.in);
            System.out.println("공격 방법을 선택하세요");
            System.out.println("1.일반 공격 2.단일 공격(MP 5 소모) 3. 광역 공격(MP 10 소모) (남은 MP = " + player.getMP() + ")");
            int selectNum = sc.nextInt();
            int targetIndex = 100;

            switch (selectNum){
                case 1:
                    System.out.print("대상 지정 ");
                    while(targetIndex > monsterList.size()){
                        for(int i=0; i<monsterList.size(); i++){
                            System.out.print(i+1 + "." + monsterList.get(i).getName() + "(HP = " + monsterList.get(i).getHP() + ") ");
                        }
                        System.out.println();
                        targetIndex = sc.nextInt();
                        if(targetIndex > monsterList.size()){
                            System.out.println("대상을 다시 지정하세요");
                            continue;
                        }
                        int realTargetIndex = targetIndex-1;

                        player.playerAttack(monsterList.get(realTargetIndex));
                        System.out.println(monsterList.get(realTargetIndex).getName() + "의 남은 HP = " + monsterList.get(realTargetIndex).getHP());
                    }
                    break;

                case 2:
                    if(player.getMP() < 5){
                        System.out.println("MP가 부족합니다");
                        continue;
                    }
                    System.out.print("대상 지정 " );
                    while(targetIndex > monsterList.size()){
                        for(int i=0; i<monsterList.size(); i++){
                            System.out.print(i+1 + "." + monsterList.get(i).getName() + "(HP = " + monsterList.get(i).getHP() + ") ");
                        }
                        System.out.println();
                        targetIndex = sc.nextInt();
                        if(targetIndex > monsterList.size()){
                            System.out.println("대상을 다시 지정하세요");
                            continue;
                        }
                        int realTargetIndex = targetIndex-1;

                        player.playerSingleAttack(monsterList.get(realTargetIndex), player.getPlayerSkill().getSingleTargetDamage());
                        System.out.println(monsterList.get(realTargetIndex).getName() + "의 남은 HP = " + monsterList.get(realTargetIndex).getHP());
                    }
                    break;

                case 3:
                    if(player.getMP() < 10){
                        System.out.println("MP가 부족합니다");
                        continue;
                    }
                    player.playerMultipleAttack(monsterList, player.getPlayerSkill().getMultipleTargetDamage());

                    for (Monster monster : monsterList) {
                        System.out.println(monster.getName() + "의 남은 HP = " + monster.getHP());
                    }
                    break;

                default:
                    System.out.println("3 이하의 숫자를 입력하세요");
                    continue;
            }
            monsterCheckLive = monsterStatusCheck();

            monsterAttack();
            playerCheckLive = playerStatusCheck();

            System.out.println();
        }
    }

    private void monsterAttack(){
        for (Monster monster : monsterList) {
            monster.monsterAttack(player);
            System.out.println('\n' + monster.getName() + "의 공격");
            System.out.println(monster.getAttack() + "의 데미지를 입었습니다.");
            System.out.println("남은 player HP = " + player.getHP());
        }
    }

    private boolean monsterStatusCheck() {
        for(int i=0; i<monsterList.size(); i++){
            if(monsterList.get(i).getHP() <= 0){
                System.out.println('\n' + monsterList.get(i).getName() + "가 죽었습니다.");
                player.getEXP(monsterList.get(i).getEXP());
                monsterList.remove(i);
            }
        }

        if(monsterList.size() == 0){
            System.out.println("모든 몬스터가 죽었습니다.");
            return false;
        }
        return true;
    }

    private boolean playerStatusCheck() {
        if(player.getHP() <= 0){
            System.out.println("Player 사망");
            return false;
        }
        return true;
    }

    public void printPlayer(){
        System.out.println(player);
    }

    @Override
    public String toString() {
        return player + "\n" + monsterList;
    }
}