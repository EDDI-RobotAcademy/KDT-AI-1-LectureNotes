package homework.diceThirdGame;

public class DicePlayer {
    private String name;
    private int[] diceArray;
    DiceDice diceArrayObject = new DiceDice(); //주사위 객체 생성

    public DicePlayer(String name){
        this.name = name;
        diceArray = new int[3]; //주사위 3개를 넣을 배열 생성
    }

    public int rollDice(int i){
        return  diceArray[i] = diceArrayObject.randomDice();
    }

    // ★ --> thirdDicecheck
    // 세 번째 주사위 수를 체크하려면 여기에 점수가 있어야 한다.
    // rollDice 당시, 생성될 때마다 누적해주는 변수를 만들어 줘야 했는데,
    // 뭔가 어떻게 해야할 지 몰라서 지금 여기서 막힘

}
