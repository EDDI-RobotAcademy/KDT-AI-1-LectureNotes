package practice.practiceDice5;

import java.util.ArrayList;
import java.util.List;

// 플레이어
// 먼저 플레이어는 이름이 있을 것
// 그리고 플레이어가 주사위를 굴려야 함
// 그럼 주사위 굴리는거랑 합하는 거랑 플레이어 쪽으로 옮겨야 할 듯? - 주사위게임2와의 차이점
// 먼저 주사위 3개 굴리기 - 주사위 리스트가 필요하려나? 일단 만들자
// 합산값도 구하기
// 그리고 스코어 구해주기

// 이제 주사위 특징
// 첫 번째 주사위가 짝수여야지 다음 주사위 굴릴 수 있다 - 완료
// 이제 세번째 주사위 굴려줘야해 -> 이건 게임 클래스로!
public class Dice5Player {
    final private String name;
    final private int DICE_COUNT = 3;
    final private List<Dice5Dice> diceList = new ArrayList<>();
    private int diceSum = 0;
    final private int FIRST_DICE_INFO = 0;
//    private int firstDiceNumber = diceList.get(FIRST_DICE_INFO).getDiceNumber();
      // 근데 이거 첫번째 순서인 코드가 뭐지? - 선생님꺼 참고
    final private int EVEN_DECISION_NUMBER = 2;

    public Dice5Player(String name) { // 이제 이렇게 하면 매개변수로 이름 지정해줘야함
        this.name = name;
    }

    public void diceRoll() {
        for (int i = 0; i < DICE_COUNT; i++) {
            diceList.add(new Dice5Dice());
            diceSum += diceList.get(i).getDiceNumber();

            final int FIRST_DICE_INFO = 0;
            int firstDiceNumber = diceList.get(FIRST_DICE_INFO).getDiceNumber();
            // 근데 이거 첫번째 순서인 코드가 뭐지? - 선생님꺼 참고

            if (firstDiceNumber % EVEN_DECISION_NUMBER != 0){
                break;
            }
        }
        System.out.println(diceList); // -> 다이스리스트에 만들어둔 주사위 클래스로 추가해줬기 때문에 알아서 주사위값 나옴
        System.out.println(diceSum);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", diceList=" + diceList +
                ", diceSum=" + diceSum +
                '}';
    }
}
