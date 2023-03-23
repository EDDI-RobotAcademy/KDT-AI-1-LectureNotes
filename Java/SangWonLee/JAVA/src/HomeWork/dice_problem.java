package HomeWork;

class Dice2 {

    final int START = 0;
    final int MAX_DICE = 4;// 주사위 갯수
    int[] diceNumberArr = new int[MAX_DICE]; // 주사위가 나온 숫자를 넣어줄 배열

    final int first_win = 4; // 첫번째 승리 조건
    final int second_win = 3; // 두번째 승리 조건
    final int third_win = 12; // 세번째 승리 조건

    int totalScore;

    public void throw_dice() { // 주사위를 굴렸을 때
        for(int i = START; i < MAX_DICE; i++) { // 주사위 갯수만큼
            int d_Number = (int) ((Math.random() * 6) + 1); // 랜덤 변수를
            diceNumberArr[i] = d_Number; //주사위 숫자 배열에 넣어주고
            setDiceNumberArr(diceNumberArr); // set, 저장
        }
    }

    public void sum_dice() { // 주사위 눈금의 합
        for (int num : getDiceNumberArr()) { // diceNumberArr 값을 하나씩 가져와서
            totalScore += num; // totalScore 에 합 한다.
            setTotalScore(totalScore); // set, 저장
            System.out.println(totalScore); // 확인용 print
        }
    }

    public void win_lose_dice() { // 승패 판정

      if(getTotalScore() % third_win == 0){ // 12의 배수가 나왔을 때
          System.out.println(getTotalScore() + " 이므로 12의 배수입니다.");
      } else if (getTotalScore() % first_win == 0 ) { // 4의 배수가 나왔을 때
          System.out.println(getTotalScore() + " 이므로 4의 배수입니다.");
      } else if (getTotalScore() % second_win == 0 ){ // 3의 배수가 나왔을 때
          System.out.println(getTotalScore() + " 이므로 3의 배수입니다.");
      }else { // 이 외에 다른 값들이 나왔을 때
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
        Dice2 d = new Dice2(); // 생성자 생성

        d.throw_dice(); // 주사위를 던지고
        d.sum_dice(); // 주사위 값들을 합치고
        d.win_lose_dice(); // 승패를 판정한다.
    }

}


