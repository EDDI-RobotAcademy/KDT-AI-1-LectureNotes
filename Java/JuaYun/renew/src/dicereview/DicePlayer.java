package dicereview;

import java.util.ArrayList;
import java.util.List;

// 플레이어가 가지고 있는 것을 생각해보기
// 주사위 이름 성적 이정도를 여기에 만들어보자
// 성적은 좀 나중으로 미루기 지금은 이름과 주사위를 할당하는 것에 초점을 맞추자
public class DicePlayer {
    private int DICE_NUM = 3;
    private String name;
    List<DiceRandom> diceRandomList = new ArrayList<>();
    private DiceScore diceScore;

    public DicePlayer(String name) {
        this.name = name;

        for (int i = 0; i < DICE_NUM; i++) {
            // DiceRandom으로 이미 랜덤다이스를 뽑았기때문에
            // 바로 class DiceRandom을 박아도됨
            diceRandomList.add(new DiceRandom(DICE_NUM));
        }
    }

    public void DiceScore() {

        int diceNumberSum = 0;
        // 일단 주사위를 더한 값을 도출해내게 만들어보자
        for (int i = 0; i < DICE_NUM; i++) {
            diceRandomList.add(new DiceRandom(i));
            diceNumberSum += diceRandomList.get(i).getDiceNumber();
        }
        int totalScore = diceNumberSum;
    }

    public static void main(String[] args) {
        DicePlayer dicePlayer1 = new DicePlayer("플레이어1");
        DicePlayer dicePlayer2 = new DicePlayer("플레이어1");
        System.out.println("플레이어1: " + dicePlayer1);
        System.out.println("플레이어2: " + dicePlayer2);


    }
}
