package homework.diceFourthGame;

public class DiceGame {
    final DicePlayer player1 = new DicePlayer("Cat");  // 게임 객체가 생성되면
    final DicePlayer player2 = new DicePlayer("Dog");  // 플레이어 객체 2명이 생성됨

    public DiceGame(){}

    public void playGame() {
        final int DICE_MAX_NUMBER = 3;
        final int FIRST_DICE = 0;
        final int ODD = 1;
        final int DICE_CONDITION = 2;

        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        final int THIRD_DICE = 2;

        for(int i = 0; i < DICE_MAX_NUMBER; i++){
            player1.dice.diceList.add(player1.rollDice());

            if(player1.dice.diceList.get(FIRST_DICE) % DICE_CONDITION == ODD){
                break;
            }

            if(player1.dice.diceList.size() == 3){
                if(player1.dice.diceList.get(THIRD_DICE) == STEAL){
                    player1.score.stealScore();
                    player2.score.lostScore();
                }

                if(player1.dice.diceList.get(THIRD_DICE) == BUFF){
                    player1.score.buffScore();
                }

                if(player1.dice.diceList.get(THIRD_DICE) == DEATH){
                    player1.score.deathScore();
                }
            }
        }

        for (int i = 0; i < DICE_MAX_NUMBER; i++) {
            player2.dice.diceList.add(player2.rollDice());
            if (player2.dice.diceList.get(FIRST_DICE) % DICE_CONDITION == ODD) {
                break;
            }
            if (player2.dice.diceList.size() == 3) {
                if (player2.dice.diceList.get(THIRD_DICE) == STEAL) {
                    player2.score.stealScore();
                    player1.score.lostScore();
                }

                if (player2.dice.diceList.get(THIRD_DICE) == BUFF) {
                    player2.score.buffScore();
                }

                if (player2.dice.diceList.get(THIRD_DICE) == DEATH) {
                    player2.score.deathScore();
                }
            }
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
