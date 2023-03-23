package homeWork;

class Dice {
    public Dice(int COUNT_DICE, int MAX_DICE, int totalScore) {
        this.COUNT_DICE = COUNT_DICE;
        this.MAX_DICE = MAX_DICE;
        this.totalScore = totalScore;
    }

    //주사위 개수
    private int COUNT_DICE;
    public int getCOUNT_DICE() {
        return COUNT_DICE;
    }
    public void setCOUNT_DICE(int COUNT_DICE) {
        this.COUNT_DICE = COUNT_DICE;
    }

    //주사위 최대값
    private int MAX_DICE;
    public int getMAX_DICE() {
        return MAX_DICE;
    }
    public void setMAX_DICE (int MAX_DICE) {
        this.MAX_DICE = MAX_DICE;
    }

    //주사위의 총합
    private int totalScore;
    public int getTotalScore() {
        return totalScore;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}


public class diceClass {
    public static void main(String[] args) {
        final int countDice = 4;
        final int maxDice = 6;
        final int startScore = 0;

        Dice game1 = new Dice(countDice, maxDice, startScore);
        System.out.println(
                "주사위 개수 :" + game1.getCOUNT_DICE() + "," +
                "주사위 최대값 :" + game1.getMAX_DICE() + ",");

        int sum = 0;
        for(int i = 0; i < game1.getCOUNT_DICE(); i++){
            int randomDice = (int)(Math.random() * game1.getMAX_DICE()+ 1);
            System.out.println((i+1) + "번째 주사위를 굴려 " + randomDice + "가 나왔습니다.");
            sum = sum + randomDice;
            game1.setTotalScore(sum);
        }
        System.out.println("주사위의 합은 " + game1.getTotalScore() + "입니다.");
        System.out.println();

        if(game1.getTotalScore() % 12 == 0){
            System.out.println("3과 4의 배수이며 승리입니다.");
        }  else if (game1.getTotalScore() % 3 == 0) {
            System.out.println("3의 배수이며 승리입니다.");
        } else if (game1.getTotalScore() % 4 == 0) {
            System.out.println("4의 배수이며 승리입니다.");
        } else {
            System.out.println("패배입니다.");
        }







    }
}
