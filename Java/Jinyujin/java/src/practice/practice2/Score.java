package practice.practice2;

public class Score {

    // 4개 주사위 합한 값을 4나 3의 배수인지 확인 - if 문
    final private int WIN_DECISION_NUMBER1 = 3;
    final private int WIN_DECISION_NUMBER2 = 4;
    private int totalSum;

    public Score(int totalSum) {
        this.totalSum = totalSum;
    } // 이걸 생성해줘야 게임클래스에서 오류가 나지 않음
      // score = new Score(diceSum); 이 부분

    public void checkWinByScore() {

        if (totalSum % WIN_DECISION_NUMBER1 == 0 ||
                totalSum % WIN_DECISION_NUMBER2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
