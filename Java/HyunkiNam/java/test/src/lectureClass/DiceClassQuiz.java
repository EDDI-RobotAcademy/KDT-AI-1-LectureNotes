package lectureClass;

class Game {

    private String name;

    public Game(String name) {
        this.name = name;
    }

    public void startGame(String name){
        System.out.println(name + "님이 주사위를 굴립니다.");
    }

    public void resultGame(final int total_score) {
        final int winnerCondition_1 = 4;
        final int winnerCondition_2 = 3;

        if (total_score % winnerCondition_1 == 0 || total_score % winnerCondition_2 == 0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배..");
        }
    }

    public String getName() {
        return name;
    }
    /*
    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    */
}

class Dice {
    final int diceNumber = 4;
    final int MIN = 1;
    final int MAX = 6;
    final int[] diceArray = new int[diceNumber];

    public Dice(){
    }

    public int[] RollDice(){
        for(int i=0; i < diceNumber; i++){
            final int randomDiceValue = (int)(Math.random() * (MAX-MIN+1)) + MIN;
            System.out.println("주사위 " + (i+1) + "의 값은 " + randomDiceValue);
            diceArray[i] = randomDiceValue;
        }
        return diceArray;
    }
}

class Score{

    public Score(){
    }

    public int TotalScore(final int[] scores){
        // final int totalScore = scores[0]+scores[1]+scores[2]+scores[3]; // 이렇게 밖에...?
        // return totalScore;
        int total_Score = 0;

        for (final int score : scores) {
            total_Score += score;
        }

        System.out.println("총 합 : " + total_Score);

        return total_Score;
    }
}
public class DiceClassQuiz {
    public static void main(String[] args) {

        Game game = new Game("홍길동");
        Dice dice = new Dice();
        Score score = new Score();

        game.startGame(game.getName());
        final int[] dices = dice.RollDice();
        final int total_score = score.TotalScore(dices);
        game.resultGame(total_score);

        //game.setTotalScore(score.TotalScore(dices));
        //game.resultGame(game.getTotalScore());
    }
}