package homework.third.diceplay;

public class Game{
    final private Dice[] diceArray;
    final private int DICE_NUM = 3;
    Player playerMe = new Player();
    Player playerYou = new Player();
    int thirdDiceArray = 0; // 세번째 주사위 수가 들어갈 곳

    public Game(){
        this.diceArray = new Dice[DICE_NUM];

        for(int i = 0; i < diceArray.length; i++){
            diceArray[i] = new Dice();

            if(diceArray[0].diceNumber % 2 == 0){
                System.out.println("주사위 값이 "+diceArray[i].diceNumber+"입니다 !");
            }
            else{
                System.out.println("첫 번째 주사위 값이 "+diceArray[i].diceNumber+"이고, 짝수가 아니므로 종료합니다.");
                return;
            }
        }

        // 세번째 주사위 특수기능
        thirdDiceArray = diceArray[DICE_NUM-1].diceNumber;
        checkThirdDice(thirdDiceArray);
    }

    public void checkThirdDice(int thirdDiceArray) {
        this.thirdDiceArray = thirdDiceArray;

        if (thirdDiceArray == 1) {
            playerMe.case1TakeScoreMe();
            playerYou.case1TakeScoreYou();
            System.out.println("친구에게 점수 3점 뺏음 [내 현재 점수 : " + playerMe.score + "]");
            System.out.println("친구에게 점수 3점 뺏김 [친구 현재 점수 : " + playerYou.score + "]");
        }
        if (thirdDiceArray == 3) {
            playerMe.case2AddScoreMe();
            playerYou.case2AddScoreYou();
            System.out.println("자신에게 2점 가산 [내 현재 점수: " + playerMe.score + "]");
            System.out.println("친구에게 2점 가산 [친구 현재 점수 : " + playerYou.score + "]");
        }
        if (thirdDiceArray == 4) {
            System.out.println("무조건 패배");
        }
    }
}

