class Dice2 {

    int START = 0;
    final int MAX_DICE = 4;
    int[] diceNumberArr = new int[MAX_DICE];

    final int first_win = 4;
    final int second_win = 3;
    final int third_win = 12;

    int totalScore;

    public void throw_dice() {

        for(int i = START; i < MAX_DICE; i++) {
            int d_Number = (int) ((Math.random() * 6) + 1);
            diceNumberArr[i] = d_Number;
            setDiceNumberArr(diceNumberArr);
        }
    }

    public  int sum_dice() {
        for (int num : getDiceNumberArr()) {
            totalScore += num;

            setTotalScore(totalScore);
            System.out.println(totalScore);

        }
        return totalScore; // 이건 필요없는거 같다. 근데 어디서 쓸 수도 있을거 같아서 냅둠
    }

    public void win_lose_dice() {

      if(getTotalScore() % third_win == 0){
          System.out.println(getTotalScore() + " 이므로 12의 배수입니다.");
      } else if (getTotalScore() % first_win == 0 ) {
          System.out.println(getTotalScore() + " 이므로 4의 배수입니다.");
      } else if (getTotalScore() % second_win == 0 ){
          System.out.println(getTotalScore() + " 이므로 3의 배수입니다.");
      }else {
          System.out.println(getTotalScore() + " 이므로 똥 입니다.");
      }


    }





    public Dice2() {
        this.diceNumberArr = diceNumberArr;
        this.totalScore = totalScore;
    }

    public int getMAX_DICE() {
        return MAX_DICE;
    }

    public int[] getDiceNumberArr() {
        return diceNumberArr;
    }

    public void setDiceNumberArr(int[] diceNumberArr) {
        this.diceNumberArr = diceNumberArr;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}





public class dice_problem {
    public static void main(String[] args) {
        Dice2 d = new Dice2();

        d.throw_dice();
        d.sum_dice();
        d.win_lose_dice();

    }

}


