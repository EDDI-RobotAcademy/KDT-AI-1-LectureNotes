package homework.homework6.diceGame5Ver2.game5;

import homework.homework6.diceGame5Ver2.utility.random.CustomRandom;

public class Dice {
    //다이스 설정
    static int diceCount = 3; //다이스 총 개수
    static int dice_Max = 6; //다이스 최대값
    static int dice_Min = 1; //다이스 최소값
    int diceNumber; //다이스 랜덤값 = 랜덤숫자
    String dicename; //다이스이름 = 주사위1 주사위2 주사위3
    static int diceSum;

    public Dice(String dicename) {
        this.dicename = dicename;
    }

    public void setDiceNumber(int diceNumber) {
        this.diceNumber = diceNumber;
    }

    public int getDiceNumber() {
        return diceNumber;
    }


    public static void rollDice(Player player){ //주사위 굴리기 함수 ==> 다이스랜덤숫자 x 3

        for (int i = 0; i <  diceCount ; i++) { //다이스 총 개수만큼 반복 = 현재 3개
            String dicename = "dice" + i + 1;   //다이스1 다이스2 다이스3
            Player.diceArray[i] = new Dice(dicename);  //을 diceArray에 넣음 ==> [주사위1][주사위2][주사위3]
            int randomNum = CustomRandom.generateNumber(dice_Max, dice_Min);
            Player.diceArray[i].setDiceNumber(randomNum);
        }

        if(Player.diceArray[0].getDiceNumber() % 2 != 0){ //첫번째 주사위가 홀수면

            for (int j = 1; j <  diceCount ; j++) {
                Player.diceArray[j].setDiceNumber(0); //나머지 주사위는 다 0으로 바꿈
                Player.diceArray[j].setDiceNumber(0);
            }
        }
    }


    public static int diceSum(Player player) { //다이스 세개의 합
        diceSum = 0;
        for (int i = 0; i <  diceCount ; i++) { //다이스 총 개수만큼 반복 = 현재 3개
            diceSum += Player.diceArray[i].getDiceNumber(); //다이스 3개의 값 모두 더한 값
        }
        return diceSum;
    }

    public static int getDiceSum() {
        return diceSum;
    }

    @Override
    public String toString() {
        return "Dice{" +
                "diceNumber=" + diceNumber +
                '}';
    }

    public static void main(String[] args) {


    }
}
