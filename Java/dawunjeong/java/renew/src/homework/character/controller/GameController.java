package homework.character.controller;


import homework.character.GameManager;

public class GameController {

    public static void main(String[] args) {

        GameManager gamemanager = new GameManager();

        // 몬스터의 수 랜덤으로 생성 후 출력
        gamemanager.addMonster(2);
        gamemanager.printMonsterList();
        System.out.println();

        // 현재 캐릭터와 몬스터의 상태 출력
        gamemanager.printcurrentHP();
        System.out.println();

        // 게임 시작
        gamemanager.playGame();

    }

}
