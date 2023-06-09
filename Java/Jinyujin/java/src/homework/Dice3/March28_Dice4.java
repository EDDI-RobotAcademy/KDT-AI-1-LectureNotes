package homework.Dice3;

// 친구와 게임 - 1:1 게임
// 주사위를 3개 굴리기
// 첫 번째 주사위가 짝수라면
// 두 번째 주사위와 세 번째 주사위를 굴릴 수 있습니다.
// 두 번째 주사위는 특수 기능이 별도로 존재하지 않습니다.
// 세 번째 주사위는 숫자 1인 경우 친구에게 점수를 3점 뺏을 수 있습니다.
// 숫자가 3인 경우엔 자신에게 2점을 가산합니다.
// 숫자가 4인 경우엔 무조건 패배하게 됩니다.
// 친구와 함께 플레이 할 수 있는 주사위 게임을 만들어주세요.

// 1. 주사위 클래스 먼저 생성 - 주사위 1-6까지 랜덤으로 잘 출력
// 2. 근데 이건 1:1이기 때문에 사용자가 있어야 함 - 사용자 클래스 생성
// 3. 사용자가 점수를 내장해야 함
// 4. 이를 위해선 사용자 클래스에서 주사위 3개 굴리고 합산까지 + 주사위 특성 입력
// 5. 첫 번째 주사위 특성까지 입력 완료
// 6. 세 번째 주사위 특성 입력 - 게임 클래스
// 7. 사용자도 랜덤으로 뜨게 하는 것 게임 클래스에서 같이
// 8. 스코어를 확인하는 클래스 생성

public class March28_Dice4 {

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("점수 판정 이후");
        game.playGame();
        game.printResult();
        game.checkWinner();
    }
}
