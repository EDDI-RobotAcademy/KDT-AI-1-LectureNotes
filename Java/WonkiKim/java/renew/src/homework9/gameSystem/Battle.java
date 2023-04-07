package homework9.gameSystem;

import homework9.component.character.Monster;
import homework9.component.character.Player;
import homework9.gameSystem.utility.CustomRandom;

import java.util.List;
import java.util.Scanner;

public class Battle {
    private static boolean annihilation = false;

    public static void attack(Player player, List<Monster> monsterList) {
        final int SINGLEATTACK = 0;
        final int ALLATTACK = 1;
        final int MP_POINT_ALLATTACK = 10;

        System.out.println("공격할 차례입니다. 단일대상 공격을 하려면 0, 전체공격을 하려면 1을 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        final int attackType = sc.nextInt();
        switch (attackType) {
            case SINGLEATTACK -> singleAttack(player, monsterList);
            case ALLATTACK -> {
                if (player.getStatus().getMp() >= MP_POINT_ALLATTACK) {
                    System.out.println("현재 mp: " + player.getStatus().getMp());
                    allAttack(player, monsterList);
                    player.getStatus().decreaseMp(MP_POINT_ALLATTACK);
                    System.out.println("전체 공격 시전후 mp: " + player.getStatus().getMp());
                } else {
                    System.out.println("mp가 모자라 전체공격을 시전할 수 없습니다. ");
                    attack(player, monsterList);
                }
            }
            default -> {
                System.out.println("잘못된 공격입니다.");
                attack(player, monsterList);
            }
        }
        if (monsterList.size() == 0) {
            annihilation = true;
        } else annihilation = false;
    }

    private static void singleAttack(Player player, List<Monster> monsterList) {
        int Damage = player.getStatus().getStrength();
        System.out.println("단일 공격 데미지는 " + Damage + "입니다.");
        System.out.println("단일 공격할 대상을 선택 해주세요");
        for (int i = 0; i < monsterList.size(); i++) {
            System.out.println("몬스터 " + monsterList.get(i).getMonsterId() + "의 hp: " + monsterList.get(i).getHp());
        }
        Scanner sc = new Scanner(System.in);
        final int targetMonsterIndex = sc.nextInt();

        Monster targetMonster = null;
        for (Monster monster : monsterList) {
            if (monster.getMonsterId() == targetMonsterIndex) {
                targetMonster = monster;
            }
        }
        if (targetMonster == null) {
            System.out.println("잘못된 단일공격 대상입니다.");
            singleAttack(player, monsterList);
            return;
        }
        targetMonster.decreaseHp(Damage);
        if (targetMonster.getHp() <= 0) {

            System.out.println("몬스터 " + targetMonster.getMonsterId() + "가 죽었습니다!");
            monsterList.remove(targetMonsterIndex);
        } else {
            System.out.println("몬스터 " + targetMonster.getMonsterId() + "의 체력이 " + targetMonster.getHp() + "가 되었습니다.");
        }
        System.out.println();
    }

    private static void allAttack(Player player, List<Monster> monsterList) {
        final float ACCURACY = (float) player.getStatus().getAbility() / 10;
        System.out.println("전체 공격입니다.");
        final float expectedDamage = player.getExpectedAllAttackDamage();
        System.out.println("기댓값(intellect x ability / 10) 데미지는 " + expectedDamage + "입니다.");
        int Damage = player.getAllAttackDamage();

        for (Monster targetMonster : monsterList) {

            final float miss = CustomRandom.generateFloatNumber();

            if (miss < ACCURACY) {
                targetMonster.decreaseHp(Damage);
                if (targetMonster.getHp() <= 0) {
                    monsterList.remove(targetMonster);
                    System.out.println("몬스터 " + targetMonster.getMonsterId() + "가 죽었습니다!");
                } else {
                    System.out.println("몬스터 " + targetMonster.getMonsterId() + "의 체력이 " + targetMonster.getHp() + "가 되었습니다.");
                }
            } else {
                System.out.println("앗! 몬스터 " + targetMonster.getMonsterId() + "에 대한 공격이 빗나갔습니다.");
            }
        }
    }

    public static boolean isAnnihilation() {
        return annihilation;
    }

    public static void monsterAttack(Player player, Monster monster) {
        final float EVASION = (float) player.getStatus().getAgility() / 10;

        int damage = monster.getDamage();
        System.out.println("몬스터 " + monster.getMonsterId() + "가 " + damage + "의 공격력으로 공격했습니다");
        float accuracy = CustomRandom.generateFloatNumber();

        if (accuracy > EVASION) {
            player.getStatus().decreaseHp(damage);
            System.out.println("플레이어가 맞았습니다. 체력이 " + player.getStatus().getHp() + "로 감소하였습니다.");
        } else {
            System.out.println("플레이어가 회피에 성공하여 체력이 닳지 않았습니다.");
        }
        if (player.getStatus().getHp() <= 0) {
            annihilation = true;
        } else annihilation = false;
    }


}
