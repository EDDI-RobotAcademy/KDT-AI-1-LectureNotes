package practice.practice2;

public class Score {

    // 4개 주사위 합한 값을 4나 3의 배수인지 확인 - if 문
    Game game = new Game();
    final int WIN_DECISION_NUMBER1 = 3;
    final int WIN_DECISION_NUMBER2 = 4;

    final int totalScore;

    public Score(int totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Score{" +
                "totalScore=" + totalScore +
                '}';
    }

    public Boolean checkWin () {

        if (totalScore % WIN_DECISION_NUMBER1 == 0 ||
                totalScore % WIN_DECISION_NUMBER2 == 0) {

            return true;
        }
        return false;


//        if (game.diceSum % WIN_DECISION_NUMBER1 == 0 ||
//                game.diceSum % WIN_DECISION_NUMBER2 == 0) {
//            System.out.println("승리");
//        } else {
//            System.out.println("패배");
//        }
    }
}
