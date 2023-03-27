package rewiew.march23_Dice3_Review;

// 문제를 봤을 때 결국 게임을 만들어야 하는구나 파악 -> 게임클래스 만들기
// 사용자 만들고 주사위 만들어야겠네 - 순서는 상관없음

// 1. 사용자 먼저 만들자 -> 사용자 클래스
// - 사용자 이름이 필요겠네 만들자
// - 사용자 만들 때는 나머지 것들은 신경 쓰지 말 것

// 2. 이제 주사위 만들자 -> 주사위 클래스
// - 게임에서 사용자가 주사위를 굴려야 하니까
// - 사용자가 주사위를 가지고 있으면 되려나? 로 시작
// 주사위 3개 굴려보기

// 이제 main에서 출력할 때 사용자 이름과 굴린 주사위 정보 출력되도록

// 3. 잘 출력된다면 주사위 점수들 합쳐야 할 것이라고 생각 가능 -> 점수 클래스 생성
// 이 점수들은 합치고 사용자마다 관리해야 하니
// 사용자 클래스에 점수 클래스를 내장

// main에서 잘 출력되나 확인

class ThirdDiceGameReview {
    final int PLAYER_NUMBER = 2;
    final Player_Review[] playArray = new Player_Review[PLAYER_NUMBER];
}

public class March23_Review {
    public static void main(String[] args) {
        ThirdDiceGameReview game = new ThirdDiceGameReview();
    }
}
