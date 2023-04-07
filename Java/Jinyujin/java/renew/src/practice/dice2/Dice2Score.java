package practice.dice2;

// 합이 3 혹은 4의 배수가 되면 승리
// diceSum 가져오기
// 승패 if 문으로 완성
// 승패 if 문을 어떻게 해결해야 할까?
// 일단 게임으로 가져가야 하겠지
public class Dice2Score {

    final private int totalScore;

    final private int WIN_DECISION1 = 3;
    final private int WIN_DECISION2 = 4;

    public Dice2Score(int totalScore) {
        this.totalScore = totalScore;
    }

    public void decideWinLose() { // 이건 그냥 메서드였을 뿐임
        if (totalScore % WIN_DECISION1 == 0 ||
                totalScore % WIN_DECISION2 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}
