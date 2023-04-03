package homework.diceThirdGame;

public class DiceGame {
    final DicePlayer player1 = new DicePlayer("Cat");  // 게임 객체가 생성되면
    final DicePlayer player2 = new DicePlayer("Dog");  // 플레이어 객체 2명이 생성됨
    public DiceGame(){}

    public void playGame() {
        final int DICE_MAX_NUMBER = 3;
        final int FIRST_DICE = 0;
        final int ODD = 1;
        final int DICE_CONDITION = 2;

        for(int i = 0; i < DICE_MAX_NUMBER; i++){
            player1.dice.diceArray[i] = player1.rollDice();

            // 세번째 주사위 저장
            player1.dice.thirdDice = player1.dice.diceArray[DICE_MAX_NUMBER - 1];

            if(player1.dice.diceArray[FIRST_DICE] % DICE_CONDITION == ODD){
                break;
            }
        }

        for(int i = 0; i < DICE_MAX_NUMBER; i++){
            player2.dice.diceArray[i] = player2.rollDice();

            // 세번째 주사위 저장
            player2.dice.thirdDice = player2.dice.diceArray[DICE_MAX_NUMBER - 1];

            if(player2.dice.diceArray[FIRST_DICE] % DICE_CONDITION == ODD){
                break;
            }
        }
    }

    public void thirdDiceGame(DicePlayer target, DicePlayer attacker){
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        if(target.dice.thirdDice == STEAL){
            target.score.stealScore(target.score.getTotalScore());
            attacker.score.lostScore(attacker.score.getTotalScore());
        }

        if(target.dice.thirdDice == BUFF){
            player1.score.buffScore(target.score.getTotalScore());
        }

        if(target.dice.thirdDice == DEATH){
            target.score.deathScore(target.score.getTotalScore());
        }
    }

    public DicePlayer win(DicePlayer player1, DicePlayer player2) {
        // ★ 만약 결과가 무승부일 경우는 처리 못했다.
        if(player1.score.getTotalScore() > player2.score.getTotalScore()){
            return player1;
        }
        return player2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ",\n\t player2=" + player2 +
                '}';
    }
}
