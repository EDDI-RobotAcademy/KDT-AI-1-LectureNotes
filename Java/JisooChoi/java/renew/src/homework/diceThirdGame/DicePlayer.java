package homework.diceThirdGame;

public class DicePlayer {
    final private int DICE_MAX_NUM = 3;
    final private int[] diceArray;
    final private String name;
    final private DiceDice diceArrayObject = new DiceDice(); //주사위 객체 생성

    // --> * 각 플레이어의 세번째 수를 받아오려면 플레이어에게 누적 점수가 있어야 한다고 판단됨
    final private DiceScore diceTotalScore = new DiceScore();

    public DicePlayer(String name){
        this.name = name;
        diceArray = new int[DICE_MAX_NUM]; //주사위 3개를 넣을 배열 생성
    }

    public int rollDice(int i){
        return  diceArray[i] = diceArrayObject.randomDice();
    }

    // ★ --> thirdDicecheck
    // 세 번째 주사위 수를 체크하려면 여기에 점수가 있어야 한다.
    // rollDice 당시, 생성될 때마다 누적해주는 변수를 만들어 줘야 했는데,
    // 뭔가 어떻게 해야할 지 몰라서 지금 여기서 막힘
    public int totalScoreNumber(){
        // 플레이어의 누적 점수를 thirdDicecheck 메서드로 보내줘서 점수를 깍든 더하든 하겠다 !

        return 0;
    }

    public String getName() {
        return name;
    }
}
