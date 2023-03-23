package homework;

// 선생님이 올려주신 답1

import java.util.Arrays;

// 하나의 클래스 안에 게임에 대한 내용을 다 넣음
class Dice3 {
    final private int MIN = 1;
    final private int MAX = 6;
    final private int WIN_DECISION1 =3;
    final private int WIN_DECISION2 =4;

    final int MAX_DICE = 4;
    final int[] diceNumberArr = new int[MAX_DICE];
    final int totalScore;


    // 생성자 -> 생성할 때 4개의 주사위를 만들고 랜덤으로 그 값을 출력하고 더할 것이다
    public Dice3() {
        int diceNumberSum = 0;

        for (int i = 0; i < diceNumberArr.length; i++){
            diceNumberArr[i] = (int)(Math.random() * MAX - MIN + 1) + MIN;
            diceNumberSum += diceNumberArr[i];
        }
        this.totalScore = diceNumberSum;
    }

    // 승리 여부를 체크하는 메서드
    public Boolean checkWin(){
        if((totalScore % WIN_DECISION1 == 0) ||
                (totalScore % WIN_DECISION2 == 0)){
            return true;
        }
        return false;
    }

//    @Override
//    public String toString() {
//        return "Dice3{" +
//                "diceNumberArr=" + Arrays.toString(diceNumberArr) +
//                ", totalScore=" + totalScore +
//                '}';
//    }
}

public class DiceHomework2Answer1 {
    public static void main(String[] args) {
        Dice3 dice = new Dice3();
        System.out.println(dice);
        System.out.println(dice.checkWin() ? "승리!" : "패배!");
    }
}
