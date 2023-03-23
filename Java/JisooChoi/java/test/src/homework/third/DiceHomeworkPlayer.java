package homework.third;

class Game{
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
                break;
                // ★ 질문
                // Q. 이 부분 때문에 java.lang.NullPointerException 오류가 뜨는 것 같은데 예외처리 하는 법을 모르겠습니다.
                // Q. 첫 번째 배열의 수가 짝수가 아니면 break로 반복문을 나가라고 하였는데, 왜 오류가 뜨는 건가요?
            }
        }

        // 세번째 주사위 특수기능
        thirdDiceArray = diceArray[DICE_NUM-1].diceNumber;
        setDiceNumber(thirdDiceArray);
    }

    public void setDiceNumber(int thirdDiceArray) {
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

class Dice{
    final private int MAX = 6;
    final private int MIN = 1;
    int diceNumber;

    public Dice(){
        this.diceNumber = (int)(Math.random() * MAX) + MIN;
    }
}

class Player{
    int score = 0;

    public Player(){
    }

    public int case1TakeScoreMe(){
        return  score += 3;
    }
    public int case1TakeScoreYou(){
        return  score -= 3;
    }
    public int case2AddScoreMe(){
        return  score += 2;
    }
    public int case2AddScoreYou(){
        return  score -= 2;
    }
}

public class DiceHomeworkPlayer {
    public static void main(String[] args) {
        System.out.println("--- 주사위 첫 번째 게임 ---");
        Game diceGame = new Game();
    }
}