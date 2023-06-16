package review1.yeoul;

import utility.random.CustomRandom;

import java.util.Arrays;

// Player라는 것을 어떻게든 전달하는게 현재 코드 구조에서는 좋음
// 고로 뒤에 Player를 붙였으나 Review2 있어야 약간은 모호성이 있음.

// 주석에 (1), (2)가 있는데 (1)이 우선 수정할 부분입니다.
// (2)는 (1)을 수정한 이후 조정해보세요.
public class FirstDiceGamePlayerReview2 {
    int DICE_NUMBER = 3;
    String PlayerName;
    int totalScore;
    static int specialDice;
    int[] DiceArray = new int[3];
    boolean issteal=false; //훔쳤니?

    public FirstDiceGamePlayerReview2(String name) {
        this.PlayerName = name;
        totalScore = rollDice();
    }

    // (2) 여기까지 완료되었다면
    // 사용자와 주사위를 분리시키는 연습을 시도해보면 좋을 것 같습니다.
    public int rollDice() {
        int Dicesum = 0;
        // (1) 일단 만드는 것에 성공했으니까
        // 아래 for 루프를 별개의 매서드로 분리하면 좋을 것 같습니다.
        // 이 부분은 주사위 점수들을 합산하는 기능을 담당합니다.
        for (int i = 0; i < DiceArray.length; i++) {
            if (DiceArray[0] % 2 != 0) {
                break;
            }
            DiceArray[i] = CustomRandom.generateNumber(1, 6);
            Dicesum += DiceArray[i];
        }

        // (1) 그리고 아래 파트는 특수 주사위의 기능 발동에 해당하는 영역입니다.
        // 역시나 분리가 되면 좋을 것 같습니다.
        specialDice = DiceArray[2];

        // 오 ㅋㅋㅋ 그냥 생성자에서 다 퉁쳐버렸네요 ?
        switch (specialDice) {
            case 1:
                Dicesum += 3;
                issteal =true; //훔쳤어요
                break;
            case 3:
                Dicesum += 2;
                break;
            case 4:
                Dicesum = -7777;
                break;

        }
        return Dicesum;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return "RealPlayer{" +
                "PlayerName='" + PlayerName + '\'' +
                ", DiceArray=" + Arrays.toString(DiceArray) +
                ", totalScore=" + totalScore +
                '}';
    }

    public void stolen (boolean issteal) {
        if (issteal){
            this.totalScore -= 3;
        }}

    public boolean issteal() {
        return issteal;
    }

    public static void main(String[] args) {
        FirstDiceGamePlayerReview2 Player1 =
                new FirstDiceGamePlayerReview2("Player1");

        FirstDiceGamePlayerReview2 Player2 =
                new FirstDiceGamePlayerReview2("Player2");

        // 오 ~ 일단 값은 잘 뽑아왔습니다.
        System.out.println("Player1: " + Player1);
        System.out.println("Player2: " + Player2);

        // 아래 부분의 경우엔 훔치기 (3번) 옵션을 테스트 해봤군요.
        Player2.stolen(Player1.issteal()); //Player1이 훔쳤어 true야 그럼 Player2에서 3점 뺏어와
        Player1.stolen(Player2.issteal());

        System.out.println("Player1: " + Player1);
        System.out.println("Player2: " + Player2);
        
        // 통으로 만들긴 했지만 좋습니다 - 굳
        if (Player1.getTotalScore() > Player2.getTotalScore()) {
            System.out.println("플레이어1 승리");
        } else {
            System.out.println("플레이어2 승리");
        }
    }
}
