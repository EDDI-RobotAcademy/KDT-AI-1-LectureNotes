package problems.prob27;


import customLibrary.RefactorDicegameManager;

// 문제 27번부터 30번입니다.
public class Problem27 {
    public static void main(String[] args) {
        RefactorDicegameManager gameManager = new RefactorDicegameManager();
        System.out.println("점수 판정 이후");
        gameManager.playGame();
        gameManager.printResult();
    }
}
