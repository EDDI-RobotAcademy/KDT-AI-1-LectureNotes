package homework.diceThirdGame;

public class DicePlayer {
    final Dice dice = new Dice(); // 플레이어 객체가 생성되면 주사위가 생성
    final DiceScore score = new DiceScore(); // 점수도 가지고 있음
    final String name;

    public DicePlayer(String name){
        this.name = name;
    }

    public int rollDice(){
        int diceArray = dice.randomDice();

        // 여기서 만들어진 주사위가 점수 객체로 향해서 총합을 구해야한다.
        score.totalDiceScore(diceArray);

        return diceArray;
    }

    @Override
    public String toString() {
        return "Player{" +
                "dice=" + dice +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
