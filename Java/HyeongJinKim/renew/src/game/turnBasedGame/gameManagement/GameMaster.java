package game.turnBasedGame.gameManagement;

import java.util.Scanner;

public class GameMaster {
    int chooseDifficulty;
    int verifyDifficulty;

    public void GameStart() {
        boolean isGameProgress = true;
        boolean isDifficultySelect = true;
        boolean isDifficultyCheck = true;

        final Scanner scan = new Scanner(System.in);

        System.out.println("게임 시작!");
        SystemMessage.printChooseDifficulty();
        while (isGameProgress) {
            while (isDifficultySelect) {
                final int EASY = 1;
                final int NORMAL = 2;
                final int HARD = 3;
                final int QUITGAME = 0;
                chooseDifficulty = scan.nextInt();
                switch (chooseDifficulty) {
                    case EASY:
                        SystemMessage.printEasyInfo();
                        isDifficultySelect = false;
                        break;
                    case NORMAL:
                        SystemMessage.printNormalInfo();
                        isDifficultySelect = false;
                        break;
                    case HARD:
                        SystemMessage.printHardInfo();
                        isDifficultySelect = false;
                        break;
                    case QUITGAME:
                        System.out.println("플레이 해 주셔서 감사합니다.");
                        isGameProgress = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.println("+------------------------------+");
                        System.out.printf("잘못된 입력입니다. %s ~ %s 사이의 정수를 입력해주세요.\n", QUITGAME, HARD);
                        SystemMessage.printChooseDifficulty();
                }
            }
            while (isDifficultyCheck) {
                final int STARTGAME = 1;
                final int QUITGAME = 2;
                System.out.printf("%s. 게임 시작   %s. 게임 종료\n", STARTGAME, QUITGAME);
                verifyDifficulty = scan.nextInt();
                switch (verifyDifficulty) {
                    case STARTGAME:
                        GameProgress.GameProgress(chooseDifficulty);
                        isDifficultyCheck = false;
                        isGameProgress = false;
                        break;
                    case QUITGAME:
                        System.out.println("플레이 해 주셔서 감사합니다.");
                        isGameProgress = false;
                        System.exit(0);
                        break;
                    default:
                        System.out.printf("잘못된 입력입니다. %s ~ %s 사이의 정수를 입력해주세요.\n", STARTGAME, QUITGAME);
                }
            }
        }
    }
}
