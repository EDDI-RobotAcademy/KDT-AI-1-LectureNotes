package practice.practiceDice5;
// 플레이어 클래스에서 첫번째 주사위 특징까지 만들어줌
// 그리고 여기서 플레이어에 따라 주사위 굴리는 거 보여주자
// 먼저 플레이어리스트 만들어주기 - 완료
// 이제 게임 플레이 메서드에서 세번째 주사위 특징 만들어주기

import java.util.ArrayList;
import java.util.List;

public class Dice5Game {
    final private int PLAYER_COUNT = 2;
    final private List<Dice5Player> playerList = new ArrayList<>();

    public Dice5Game() {
        for (int i = 0; i < PLAYER_COUNT; i++) {
            playerList.add(new Dice5Player("플레이어" +(i+1)));
        }
    }

    // 세 번째 주사위 찾기
    // 플레이어 리스트를 이용해볼 것
    // 주사위 리스트는 지금 이미 저쪽에 선언해둬서 또 하면 중복임
    public void findThirdDiceNumber() {
        // 플레이어가 두 명이 세 번씩 주사위 굴리잖아
        // 여기서부터 다시!!!

    }

    // 세 번째 주사위 특성
    // 숫자 1인 경우 친구꺼 3점 뺏고 나한테 3점 추가
    // 숫자 3인 경우 자신에게 2점 추가
    // 숫자 4인 경우 끝 - 패배
    public void playGame() {
        // 세 번째 주사위를 찾기 위한 메서드 만들어보자 - 위로
        // - 쌤꺼 참고함
        // 내 생각으로 할 수 있도록!

    }
}
