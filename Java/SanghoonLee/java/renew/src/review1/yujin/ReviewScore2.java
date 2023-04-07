package review1.yujin;

public class ReviewScore2 {
    final private int WIN_DECISION_NUMBER1 = 3;
    final private int WIN_DECISION_NUMBER2 = 4;
    private int totalSum;

    public ReviewScore2() {

        if (totalSum % WIN_DECISION_NUMBER1 == 0 ||
                totalSum % WIN_DECISION_NUMBER2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }

    public ReviewScore2 (int totalSum) {
        this.totalSum = totalSum;
    }

    public void checkWinByScore () {
        if (totalSum % WIN_DECISION_NUMBER1 == 0 ||
                totalSum % WIN_DECISION_NUMBER2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
