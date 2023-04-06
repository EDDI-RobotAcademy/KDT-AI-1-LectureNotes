package problem.gameCharacterProb1;

import problem.gameCharacterProb1.enemy.Enemy;
import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    final private int CHARACTER_NUM = 2;
    final private int ENEMY_NUM = 5;
    final private List<Character> characterList = new ArrayList<>();
    final private List<Enemy> enemyList = new ArrayList<>();

    public GameManager() {
        for (int i = 0; i < CHARACTER_NUM; i++) {
            characterList.add(new Character("플레이어" + (i + 1)));
            System.out.println(characterList.get(i).getName());
        }
        for (int j = 0; j < ENEMY_NUM; j++) {
            enemyList.add(new Enemy("적" + (j + 1)));
            System.out.println(enemyList.get(j).getName());
        }
    }

    public void playGame() {
        boolean characterCheckLive = true;
        boolean enemyCheckLive = true;

        while (characterCheckLive && enemyCheckLive) {
            for (int i = 0; i < characterList.size(); i++) {
                Scanner scanner = new Scanner(System.in);
                System.out.println(characterList.get(i).getName() + "의 차례");

                System.out.println("사용할 스킬은 선택하세요");
                System.out.println("1. 단일 공격  2. 광역 공격");

                int skillSelect = scanner.nextInt();
                int targetIndex;

                switch (skillSelect) {
                    case 1:
                        System.out.print("단일 공격을 사용합니다. \n 스킬을 사용할 적을 지목하세요 \n");
                        for (int j = 0; j < enemyList.size(); j++) {
                            System.out.println(j + 1 + "." + enemyList.get(j).getName() + " 체력: " +
                                    enemyList.get(j).getHealth());
                        }
                        targetIndex = scanner.nextInt();
                        if (targetIndex > enemyList.size()) {
                            System.out.println("지목할 적이 없습니다. 다시 지정하세요");
                        }
                        int targetEnemyIndex = targetIndex - 1;

                        characterList.get(i).characterNormalAtk(enemyList.get(targetEnemyIndex),
                                characterList.get(i).getNormalAtkSkill().getSkillDamage());
                        System.out.println(enemyList.get(targetEnemyIndex).getName() + " 의 남은 체력은 " +
                                enemyList.get(targetEnemyIndex).getHealth());
                        break;

                    case 2:
                        System.out.println("광역 공격을 사용합니다.");
                        characterList.get(i).characterWideAtk(enemyList,
                                characterList.get(i).getWideAtkSkill().getSkillDamage());

                        for (int h = 0; h < enemyList.size(); h++) {
                            System.out.println(enemyList.get(h).getName() + "의 남은 체력은 " +
                                    enemyList.get(h).getHealth());
                        }
                        break;

                    default:
                        System.out.println("스킬이 존재하지 않습니다. \n 다시 지정해 주세요");
                        i--;
                        continue;
                }

                for (int l = 0; l < ENEMY_NUM; l++) {
                    enemyCheckLive = enemyStatus();
                }
            }
            enemyAtk();
            characterCheckLive = characterStatus();
        }
    }



    private void enemyAtk() {
        for (int i = 0; i < enemyList.size(); i++) {
            int targetCharacterIndex = findTargetCharacterIndex();
            enemyList.get(i).enemyAtk(characterList.get(targetCharacterIndex));
            System.out.println(enemyList.get(i).getName() + " 이 " +
                    characterList.get(targetCharacterIndex).getName() + "을(를) 공격해 체력이" +
                    characterList.get(targetCharacterIndex).getHealth() + "이 되었습니다.");
            characterStatus();
        }
    }

    private int findTargetCharacterIndex() {
        int targetCharacterIndex = CustomRandom.generateNumber(characterList.size() - 1);
        return targetCharacterIndex;
    }


    private boolean enemyStatus() {
        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i).getHealth() < 1) {
                System.out.println(enemyList.get(i).getName() + "을(를) 처치했습니다.");
                enemyList.remove(i);
            }
        }

        if (enemyList.size() == 0) {
            System.out.println("모든 적을 처치했습니다. \n 게임에 승리하셨습니다.");
            return false;
        }
        return true;
    }

    private boolean characterStatus() {
        for (int i = 0; i < characterList.size(); i++) {
            if (characterList.get(i).getHealth() < 1) {
                System.out.println(characterList.get(i).getName() + "이(가) 사망했습니다.");
                characterList.remove(i);
            }
        }
        if (characterList.size() == 0) {
            System.out.println("모든 플레이어가 사망했습니다. \n 게임에 패배하셨습니다.");
            return false;
        }
        return true;
    }
}
