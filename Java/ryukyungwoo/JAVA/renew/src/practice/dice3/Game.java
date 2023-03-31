package practice.dice3;
class GameManager {
    /*
        Dice를 만들고 바로 3번 굴리는 거 보다
        Dice 랑 DiceRolling 따로 나누기
     */
    /*
        플레이어 리스트 안에 다이스 리스트를 못 넣으니까
        플레이어 따로
        다이스 따로 한 다음
        플레이어랑 다이스를 매칭 시키기?
    */
    /*
    필요한 것
    만들어진 플레이어 리스트랑
    다이스 리스트를 합치기
    List<List<>> 말고 다른 방법 생각하기
    어떻게 매칭 시킴?
    Dice()하면 3개가 나오고
    Player()하면 2개가 나옴
    일단 필요할것 같은 상수 다 만들기
     */
//    final private int selectedPlayerNumber; // 원하는 순서의 플레이어

//    final private int thirdDiceNumberIfOne; // 세 번째 주사위가 1이라면
//    final private int thirdDiceNumberIfThree; // 세 번째 주사위가 3이라면
//    final private int thirdDiceNumberIfFour; // 세 번째 주사위가 4라면
        final private int firstDecisionNumber; // 첫번째 주사위 판별 넘버
        final private int thirdDecisionNumber; // 세 번째 주사위 판별 넘버
        final private int ODD = 2; // 짝수 판결문
      public GameManager () {
          firstDecisionNumber = 0;
          thirdDecisionNumber = 2;
          SelectedDice selectedDice = new SelectedDice(firstDecisionNumber);
          if (selectedDice.getSelectedDiceNumber() % ODD == 0) {
                // 막힘
              // 플레이어랑 다이스랑 어떻게 매칭시켜야 될 지 모르겠어요
          }

    }
}
public class Game {
}