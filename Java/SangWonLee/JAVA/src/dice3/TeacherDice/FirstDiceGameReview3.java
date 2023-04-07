package dice3.TeacherDice;

import java.util.List;

public class FirstDiceGameReview3 {
    public static void main(String[] args) {
        // Player 객체를 만들었습니다.
        // 그러나 내부에서 다루고 있는 내용은 playerList에 해당합니다.
        // 그러므로 PlayerList 라는 형태로 만들었으면 조금 더 혼선을 최소화 할 수 있었을 것입니다.
        ReviewPlayer3 player = new ReviewPlayer3();
        player.addPlayer();

        // Dice라고 표현하였지만 가만 보니까 주사위 리스트를 다루고 있습니다.
        // 그러므로 DiceList라고 표현 했으면 더 좋았을 것 같습니다.
        // 사용자 숫자만큼 diceList1, diceList2, ... , diecListN이
        // 만들어질 것이므로 확장성에 지대한 문제가 있긴합니다.
        ReviewDice3 dice1 = new ReviewDice3();
        ReviewDice3 dice2 = new ReviewDice3();

        List<Integer> doDice1 = dice1.rollDice();
        List<Integer> doDice2 = dice2.rollDice();
        // 위의 4줄이 사실 하나의 묶음으로 동작한다 봐도 무방합니다.
        // 여기서 diceList1.getDiceList() 형태로 표현을 하는 것이 더 좋았을 것 같습니다.


        System.out.println(player.playerName1 + " 의 주사위는 : " + doDice1);
        System.out.println(player.playerName2 + " 의 주사위는 : " + doDice2);

        ReviewScore3 score1 = new ReviewScore3(doDice1);
        ReviewScore3 score2 = new ReviewScore3(doDice2);
        System.out.println("시작 스코어 → " + score1.Score + "  :  " + score2.Score);

        ReviewSpecialDice3 special = new ReviewSpecialDice3();

        // 이 파트 해석이 상당히 어렵습니다.
        // 매서드 이름이 일단 goodDice라서 음 ? 이게 뭐지 ?
        // 엄청난 혼선이 발생하고 있습니다.
        // totalScore를 리스트 형태로 리턴하였으나
        // 리턴 결과를 받아주는 정보가 없는 상황입니다.
        special.goodDice(
                doDice1, doDice2,
                player.playerName1, player.playerName2,
                score1.Score, score2.Score);

        System.out.println(
                "결과 → " + special.totalScore.get(0) +
                        "  :  " + special.totalScore.get(1));

        // 승자 판정
        Versus vs = new Versus();
        vs.pandan(special.totalScore, player.playerName1, player.playerName2);

        // 리뷰 이후 후유증이 꽤 강하네요.
        // 변수 이름과 매서드 이름,
        // 그리고 매서드가 행하는 행위들을
        // 목적에 맞게 잘 분리하는 연습이 필요할 것 같습니다.
        // 일단 그래도 코드를 굴렸다는 부분에 의의를 두면 좋을 것 같습니다!
    }
}