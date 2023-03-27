package homework.homework1.refacktor;

public class rollDice {
    public static int rollDice(int diceCount, int Max, int Min , int startScore){
        int[] diceArray = new int [diceCount];
        for (int i = 0; i < diceArray.length; i++){
            diceArray[i] =  randomNumber.randomNumber(Max, Min);
            System.out.println((i+1)+ "번째 주사위를 굴려" + diceArray[i] + "가 나왔습니다.");
            startScore += diceArray[i];
        }
        System.out.println("주사위의 합은" + startScore + "입니다.");
//        diceClass.setstartScore(startScore);
       return startScore;
    }
}
