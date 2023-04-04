package turnBasedGame.gameManagement;

import turnBasedGame.objects.monster.Monster;
import turnBasedGame.objects.player.PlayerInfo;
import turnBasedGame.objects.player.playerAttacks.Attack;
import turnBasedGame.objects.player.playerAttacks.MultipleTargetAttack;
import turnBasedGame.objects.player.playerAttacks.SingleTargetAttack;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static turnBasedGame.gameManagement.SystemMessage.playerInfo;

public class GameProgress {
    public final static List<Monster> monsterList = new ArrayList<>();

    public static void GameProgress(int difficulty) {
        PlayerInfo playerInfo = new PlayerInfo();
        final int MONSTER_COUNT = difficulty + 1;
        int attackType;
        int targetIndex;
        boolean checkDeadPlayer = false;
        boolean checkDeadMonster = false;

        int singleSkillCoolDown = 0;
        int multipleSkillCoolDown = 0;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < MONSTER_COUNT; i++) {
            monsterList.add(new Monster());
        }

        while (!checkDeadPlayer && !checkDeadMonster) {
            System.out.println("+------------------------------+");
            for (int i = 0; i < monsterList.size(); i++) {
                System.out.println("[ " + (i + 1) + "번 몬스터 ] 체력: " + monsterList.get(i).getHealthPoint());
            }
            SystemMessage.printYourTurn();
            attackType = scan.nextInt();
            final int ATTACK = 1;
            final int SINGLESKILL = 2;
            final int MULTIPLESKILL = 3;
            final int STATUS = 4;
            int enemyIndex;

            switch (attackType) {
                case ATTACK:
                    new Attack(playerInfo.getStrength(), playerInfo.getDexterity());
                    SystemMessage.printAttackInfo();
                    for (int i = 0; i < monsterList.size(); i++) {
                        System.out.println("[ " + (i + 1) + "번 몬스터 ] 체력: " + monsterList.get(i).getHealthPoint());
                    }
                    targetIndex = scan.nextInt();
                    if (targetIndex > monsterList.size()) {
                        System.out.println("올바른 대상이 아닙니다.");
                        System.out.println("+------------------------------+");
                        System.out.println("공격 대상을 입력하세요.");
                    }
                    enemyIndex = targetIndex - 1;
                    playerInfo.playerAttack(monsterList.get(enemyIndex), (int) Attack.getAttackDMG());
                    if (Attack.isCritical()) {
                        System.out.println("CRITICAL!!!");
                    }
                    System.out.println(targetIndex + "번 몬스터를 공격해 " + (int) Attack.getAttackDMG() + "의 데미지를 입혔습니다!");
                    break;

                case SINGLESKILL:
                    if (singleSkillCoolDown != 0) {
                        System.out.printf("쿨타임입니다. 남은 시간: %d턴\n", singleSkillCoolDown);
                        continue;
                    }
                    else {
                        new SingleTargetAttack(playerInfo.getStrength(), playerInfo.getDexterity(), playerInfo.getIntelligence());
                        SystemMessage.printSingleSkillInfo();
                        System.out.println("공격 대상을 입력하세요.");
                        for (int i = 0; i < monsterList.size(); i++) {
                            System.out.println("[ " + (i + 1) + "번 몬스터 ] 체력: " + monsterList.get(i).getHealthPoint());
                        }
                        targetIndex = scan.nextInt();
                        if (targetIndex > monsterList.size()) {
                            System.out.println("올바른 대상이 아닙니다.");
                            System.out.println("+------------------------------+");
                            System.out.println("공격 대상을 입력하세요.");
                        }
                        enemyIndex = targetIndex - 1;
                        playerInfo.playerSingleSkill(monsterList.get(enemyIndex), (int) SingleTargetAttack.getSingleTargetAttackDMG());
                        if (Attack.isCritical()) {
                            System.out.println("CRITICAL!!!");
                        }
                        System.out.println(targetIndex + "번 몬스터를 공격해 " + (int) SingleTargetAttack.getSingleTargetAttackDMG() + "의 데미지를 입혔습니다!");
                        singleSkillCoolDown = 2;
                        break;
                    }

                case MULTIPLESKILL:
                    /* TODO: for Loop 몬스터 개체 수 만큼 돌리고 Loop 안에서 Random 함수 호출
                             광역스킬도 개체별로 다른 데미지 줄 수 있을듯? 아마? */
                    if (multipleSkillCoolDown != 0) {
                        System.out.printf("쿨타임입니다. 남은 시간: %d턴\n", multipleSkillCoolDown);
                        continue;
                    }
                    else {
                        new MultipleTargetAttack(playerInfo.getStrength(), playerInfo.getDexterity(), playerInfo.getIntelligence());
                        SystemMessage.printMultipleSkillInfo();
                        playerInfo.playerMultipleSkill(monsterList, (int) MultipleTargetAttack.getMultipleTargetAttackDMG());
                        for (int i = 0; i < monsterList.size(); i++) {
                            System.out.println("[ " + (i + 1) + "번 몬스터 ] 체력: " + monsterList.get(i).getHealthPoint());
                        }

                        if (Attack.isCritical()) {
                            System.out.println("CRITICAL!!!");
                        }
                        System.out.println("광역 스킬 공격으로 적들에게 " + (int) MultipleTargetAttack.getMultipleTargetAttackDMG() + "의 데미지를 입혔습니다!");
                        multipleSkillCoolDown = 3;
                        break;
                    }

                case STATUS:
                    System.out.println("+------------------------------+");
                    SystemMessage.printPlayerInfo();
                    break;

                default:
                    System.out.printf("잘못된 입력입니다. %s ~ %s 사이의 정수를 입력해주세요.\n", ATTACK, STATUS);
            }

            if (singleSkillCoolDown != 0) {
                singleSkillCoolDown--;
            }
            if (multipleSkillCoolDown != 0) {
                multipleSkillCoolDown--;
            }

            for (int i = 0; i < monsterList.size(); i++) {
                checkDeadMonster = monsterCounter();
            }
            if (attackType != 4) {
                monsterAttack();
            }
            checkDeadPlayer = playerStatus();
        }
    }

    private static void monsterAttack() {
        for (int i = 0; i < monsterList.size(); i++) {
            final int HUNDREDTH = 99;
            int randomNum = CustomRandom.generateNumber(HUNDREDTH);
            System.out.println("+------------------------------+");
            if (playerInfo.getAgility() > randomNum) {
                System.out.println("회피 성공!");
                System.out.println("[ " + (i + 1) + "번 몬스터] 의 공격을 회피했습니다!");
            }
            else {
                monsterList.get(i).monsterAttack(playerInfo);
                System.out.println("[ " + (i + 1) + "번 몬스터] 의 공격!");
                System.out.println("남은 체력: " + playerInfo.getHealthPoint());
            }
        }
    }

    private static boolean monsterCounter() {
        for (int i = 0; i < monsterList.size(); i++) {
            if (monsterList.get(i).getHealthPoint() < 1) {
                System.out.println("[ " + (i + 1) + "번 몬스터 처치! ]");
                monsterList.remove(i);
                System.out.println("남은 적: " + monsterList.size());
            }
        }
        if (monsterList.size() == 0) {
            System.out.println("승리");
            System.out.println("- 몬스터를 모두 처치하였습니다 -");
            return true;
        }
        else
            return false;
    }

    private static boolean playerStatus() {
        if (playerInfo.getHealthPoint() < 1) {
            System.out.println("게임 오버!");
            System.out.println("- HP가 0이 되었습니다 -");
            return true;
        }
        else
            return false;
    }
}
