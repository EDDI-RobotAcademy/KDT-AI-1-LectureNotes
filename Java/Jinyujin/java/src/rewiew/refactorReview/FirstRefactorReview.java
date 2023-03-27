package rewiew.refactorReview;

// 리팩터링을 하는 이유는 보기도 손대기도 쓰기도 편안하게 하기 위해서!
// 기존의 코드를 수정하지 않고도 코드의 구조를 개선하거나 유지보수를 용이하게 한다
// 중복된 코드 제거
// 변수나 메소드의 이름을 더 정확하게 바꿈

// 리팩토링이란 필요하다 느껴질 때 만드는 것
// 무언가를 할 때 봐야 하는 것이 너무 많아 분리가 필요하다고 생각되면 바로 클래스의 메서드로 분리하면 된다
// 현재는 기능 분리를 하는 정도로


import rewiew.utility.random_Review.CustomRandomReview;

class FirstRefactorGameReview {
    int MAX_DICE_NUM = 3;
    int MAX = 6;
    int MIN = 1;
    int diceSum = 0;
    int[] diceNumberArray;

    public FirstRefactorGameReview() {
        diceNumberArray = new int[MAX_DICE_NUM];
        rollDice();
        sumDiceNumber();
    }

    // 주사위 굴리기
    private void sumDiceNumber() {
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceSum += diceNumberArray[i];
        }
    }

    public void rollDice() {
        for (int i = 0; i < MAX_DICE_NUM; i++) {
            diceNumberArray[i] = CustomRandomReview.generateNumber(MIN, MAX);
        }
    }

    public void checkWin() {
        if(diceSum % 3 == 0 || diceSum % 4 ==0) {
            System.out.println("승리!");
        } else {
            System.out.println("패배!");
        }
    }
}
public class FirstRefactorReview {
    public static void main(String[] args) {
        FirstRefactorGameReview frGame = new FirstRefactorGameReview();
        frGame.checkWin();
    }

}
