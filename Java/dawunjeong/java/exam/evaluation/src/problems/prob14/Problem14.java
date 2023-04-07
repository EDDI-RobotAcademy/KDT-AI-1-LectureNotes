package problems.prob14;

import customLibrary.RandomGenerator;

import java.util.Scanner;

// 문제 14번
class LottoGame{
    final private int winnerNumber;
    private int selectedNumber;
    final private int CHANCE = 7;
    Scanner scan = new Scanner(System.in);

    public LottoGame() {
        winnerNumber = RandomGenerator.generateNumber(3,33);
    }

    public void playGame() {
        for (int i = 0; i < CHANCE; i++) {
            System.out.println((i + 1) + "번째 기회입니다.");
            selectedNumber = scan.nextInt();

            if (winnerNumber == selectedNumber) {
                System.out.println("승리입니다!");
                break;
            } else {
                System.out.println("맞지 않습니다.");
                System.out.println();

                if(i != 6){
                    System.out.println("원하는 숫자를 다시 입력하세요.");
                }
                if(i == 6){
                    System.out.println("7번의 기회를 모두 소진하였습니다. 패배입니다.");
                }
            }
        }
    }
}
public class Problem14 {
    public static void main(String[] args) {
        System.out.println("3에서 33까지 숫자 중 원하는 번호를 입력하세요.");
        LottoGame lottoGame = new LottoGame();
        lottoGame.playGame();
    }
}
