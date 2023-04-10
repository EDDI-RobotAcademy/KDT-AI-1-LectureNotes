package game.turnBasedGame.gameManagement;

import game.turnBasedGame.objects.player.PlayerInfo;

public class SystemMessage {
    static PlayerInfo playerInfo = new PlayerInfo();

    /* TODO: 관리하기 불편함
        변수 불러와서 문자열 포매팅하기 */

    public static void printChooseDifficulty() {
        System.out.println("게임 설명");
        System.out.println("========난이도를 선택하세요========");
        System.out.println("1. Easy   2. Normal   3. Hard");
        System.out.println("0. 게임 종료");
    }

    public static void printEasyInfo() {
        System.out.println("+------------ Easy ------------+");
        System.out.println("대충 이지모드 설명");
        System.out.println("+------------------------------+");
    }

    public static void printNormalInfo() {
        System.out.println("+----------- Normal -----------+");
        System.out.println("대충 노말모드 설명");
        System.out.println("+------------------------------+");
    }

    public static void printHardInfo() {
        System.out.println("+------------ Hard ------------+");
        System.out.println("대충 하드모드 설명");
        System.out.println("+------------------------------+");
    }

    public static void printYourTurn() {
        System.out.println("+------------------------------+");
        System.out.println("당신의 차례입니다.");
        System.out.println("공격 방식을 선택해주세요.");
        System.out.println("[ 1. 기본 공격 ]");
        System.out.println("[ 2. 단일 대상 스킬 공격 ]");
        System.out.println("[ 3. 광역 스킬 공격 ]");
        System.out.println("[ 4. 플레이어 정보 ]");
    }

    public static void printAttackInfo() {
        System.out.println("+------------------------------+");
        System.out.println("< 일반 공격 >");
        System.out.println("단일 적에게 [완력 * 0.6] ~ [완력]사이의 랜덤한 데미지를 입힌다.");
        System.out.println("일정 확률로 크리티컬이 발생하여 적에게 1.2배의 데미지를 입힌다.");
        System.out.println("크리티컬 확률은 [재주] 수치에 영향을 받는다.");
        System.out.println("+------------------------------+");
        System.out.println("공격 대상을 입력하세요.");
    }

    public static void printSingleSkillInfo() {
        System.out.println("+------------------------------+");
        System.out.println("< 단일 대상 스킬 공격 >");
        System.out.println("단일 적에게 [완력 * 0.8] ~ [완력 * 1.2]사이의 랜덤한 데미지를 입힌다.");
        System.out.println("일정 확률로 크리티컬이 발생하여 적에게 1.5배의 데미지를 입힌다.");
        System.out.println("스킬 공격 시 [지능] 수치만큼 적에게 추가 데미지를 입힌다.");
        System.out.println("크리티컬 확률은 [재주] 수치에 영향을 받는다.");
        System.out.println("< 단일 대상 스킬 공격 >은 [재주] 수치로 발생하는 크리티컬 확률 보을 2배로 받는다.");
        System.out.println("+------------------------------+");
    }

    public static void printMultipleSkillInfo() {
        System.out.println("+------------------------------+");
        System.out.println("< 광역 스킬 공격 >");
        System.out.println("단일 적에게 [완력 * 0.6] ~ [완력 * 1.2]사이의 랜덤한 데미지를 입힌다.");
        System.out.println("일정 확률로 크리티컬이 발생하여 적에게 1.5배의 데미지를 입힌다.");
        System.out.println("스킬 공격 시 [지능] 수치만큼 적에게 추가 데미지를 입힌다.");
        System.out.println("크리티컬 확률은 [재주] 수치에 영향을 받는다.");
        System.out.println("+------------------------------+");
    }

    public static void printPlayerInfo() {
        System.out.println("[ 현재 체력 ]: " + playerInfo.getHealthPoint());
        System.out.println("[ 완력 ]: " + playerInfo.getStrength());
        System.out.println("[ 민첩 ]: " + playerInfo.getAgility());
        System.out.println("[ 재주 ]: " + playerInfo.getDexterity());
        System.out.println("[ 지능 ]: " + playerInfo.getIntelligence());
    }
}
