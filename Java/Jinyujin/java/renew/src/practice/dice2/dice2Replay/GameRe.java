package practice.dice2.dice2Replay;

import java.util.ArrayList;
import java.util.List;

// 4개 주사위 굴리는 클래스
// 일단 주사위 리스트를 만들자
// -> 리스트 타입을 주사위 타입으로!
// 이제 그 4개 주사위의 합 구하기
public class GameRe {
    final private int MAX_DICE_NUMBER = 4;
    final private List<DiceRe> diceList = new ArrayList<>();
    int diceSum = 0;
    private DecideWin decideWin;

    public void rollDice() {

        for (int i = 0; i < MAX_DICE_NUMBER; i++) {
            diceList.add(new DiceRe());
            diceSum += diceList.get(i).getDiceNumber();
            // 이건 diceList.get(i) 까지는
            // DiceRe타입의 리스트이기 때문에 더할 수가 없음
            // 그래서 뒤에 diceNumber라는 getter를 붙여줘야함
            // 왜?
            // public int getDiceNumber() {
            //        return diceNumber;
            //    }
            // getDiceNumber() - 이 메서드 자체가 diceNumber를 반환!!
            // 그래서 이걸 붙이면 diceNumber 중 하나가 되는건가봐
            // 메서드라는 것을 기억하자!!

            decideWin = new DecideWin(diceSum);
            // DecideWin 클래스에서 매개변수로 int score가 들어가게 해놨으므로
            // 그것에 적합한 것이 바로 diceSum (애초에 diceSum 대체가 score 였음)
            // 그리고 diceSum이 계산되어 있는 메서드 안에서 선언해야
            // 같은 diceSum이 들어가서 제대로 된 값 나옴
            // 위치는 같은 메서드이기만 하면 for문 안이던 밖이던 상관없음
        }
        System.out.println("diceList > " + diceList);
        System.out.println("주사위 총 합은: " + diceSum);
    }

    public void lastJudgement() {
        decideWin.decideWinner();
    }
}
