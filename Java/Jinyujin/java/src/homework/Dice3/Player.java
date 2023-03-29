package homework.Dice3;

// 사용자 클래스
// 사용자는 뭐가 필요할까?
// 사용자 이름 - 누구 차례인지 구분해야 하니까

// 주사위 합산된 것 - 사용자마다 관리해야 하니 사용자 클래스에 내장
// Game 클래스에서 합산했으나 Player 클래스에 내장하는 방법을 몰라
// Player 클래스에서 다시 합산한 주사위 변수 생성
// 그냥 단순하게 하자. Player에 내장해야 하니 여기에 선언해준 걸로

import java.util.Arrays;

// 주사위 3개 굴리는 것도 합산도 다 여기서 하는게 나음
public class Player {

    final private String name;
    Dice[] dice = new Dice[3]; // Dice 클래스의 정보를 dice 배열 변수에 길이 3만큼 생성
                               // 이렇게 했을 때 값은 안들어가 있음 - 그니까 값을 넣어주자 (for문 이용)
    GameScore gameScore;


    public Player(String name) { // => Player 메소드. 'Player'클래스의 생성자
                                 // name이라는 매개변수를 받아서 'Player' 객체를 생성
        this.name = name;
        // 이 상태만으로는 이름이 출력 안됨 - 뭘 해줘야 할까?
        // 메인에서 이름을 써줬어야 함
        // Player player = new Player("Player1"); -> 이러고 출력해야

        // 그리고 이제 player랑 주사위 결과랑 같이 나오도록 해야 할 것 같애

        int diceSum = rollDice(); // rollDice 메소드를 호출하여 그 값을 diceSum에 저장해라
        // 근데 이미 주사위 돌린 값을 Dice 클래스에 구해놈
        // 여기서 단단히 막힘
        gameScore = new GameScore(diceSum);
    }

    private int rollDice() {

        int diceSum = 0;

        for (int i = 0; i < 3; i++) {
            dice[i] = new Dice(); // dice 배열에 값 지정 - 합산
            diceSum = dice[i].getDiceNumber(); // 합산까지 구하기 완료
            // 사용자에게 합산 값까지는 부여 완료
            // 이제 주사위의 특성 입력

            if (dice[0].getDiceNumber() % 2 == 1) {
                // 그냥 dice[0] 이라고만 하면 오류
                // dice[0].getDiceNumber()
                // getDiceNumber()는 Dice 클래스에서 선언된 메소드로
                // 해당 주사위 객체의 수 반환 - 여기선 첫 번째 주사위
                break;
            }
        }
        return diceSum; // rollDice() 메소드에서 계산된 diceSum값 반환
                        // 즉, 첫 번째 주사위가 짝수면 다시 diceSum 값을 반환하라는 뜻
        // 여기까지 첫 번째 주사위 특성 완료 - 이제 세 번째 주사위 특성 설정
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", dice=" + Arrays.toString(dice) +
                ", gameScore=" + gameScore +
                '}';
    }

    public Dice getSelectedDice(int index) {
        return dice[index];
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }
}
