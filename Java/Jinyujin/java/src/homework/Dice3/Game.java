package homework.Dice3;

// 게임판 벌이는 클래스
public class Game {

    // 사용자 관리하기 위한 배열 설정
    Player[] playerArray = new Player[2]; // 2명이니까

    public Game() { // 사용자 랜덤 번호 부여
        for (int i = 0; i < 2; i++) {
            playerArray[i] = new Player("플레이어" + (i+1));
            System.out.println(playerArray[i]); // 이건 왜 쓴건지 결과로 보자
        }
    }

    // 상대받 인덱스를 찾기 위한 메서드 - 이 부분은 모르겠음
    int findTargetPlayerIndex (int currentPlayerIndex) {
        // 상대편 찾기 (1:1 상황)
        int targetPlayerIndex = 0;

        // 내가 0번이면 상대방은 1번임(1:1이니까)
        if (currentPlayerIndex == 0) {
            targetPlayerIndex = 1; // 1은 대입하는 것 == 아님
        }
        return  targetPlayerIndex;
        // 여기까지 변수 이름이 어려운거지
        // 그냥 내가 0이면 상대방은 1인 메소드
    }

       // 세 번째 주사위 특성
       // 번호 찾기
    int findSpecialDiceNumber (int playerIndex) {
        // 플레이어 정보에서 선택한 2번 인덱스의 Dice 객체를 확보함 = 3번째 주사위
        Dice currentPlayerSpecialDice =
                playerArray[playerIndex].getSelectedDice(2);

        // 만약 null을 가져왔다면 없으므로 0점을 리턴
        if(currentPlayerSpecialDice == null) {
            return 0;
        }

        // 값이 존재한다면 이 특수 주사위의 번호를 확보함
        int currentPlayerSpecialDiceNumber =
                currentPlayerSpecialDice.getDiceNumber();

        // 해당 값을 출력해서 전달함
        return currentPlayerSpecialDiceNumber;
    }

    // 게임 시작
    public void playGame() {
        // 특수 주사위의 옵션들
        final int STEAL = 1;
        final int BUFF = 3;
        final int DEATH = 4;

        // 특수 주사위의 옵션 행위에 해당하는 점수 값들
        int STEAL_SCORE = 3;
        int BUFF_SCORE = 2;
        int DEATH_SCORE = -1;

        // 사용자별 특수 주사위 옵션을 적용하기 위해 루프를 돔
        for (int i = 0; i < 2; i++) {
            // 현재 사용자의 특수 주사위의 눈금을 확인함
            int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);

            // 0이면 동작할 필요 없으니 이 플레이어를 제낌
            if (currentPlayerSpecialDiceNumber == 0) {
                continue;
            }
            // TODO: 확장성이 떨어지므로 개선 필요 -> 상대편 찾기 (1:1 상황)
            int targetPlayerIndex = findTargetPlayerIndex(i);

            // 상대방의 점수 객체를 확보함
            GameScore targetPlayerScore =
                    playerArray[targetPlayerIndex].getGameScore();

            // 자신의 점수 객체를 확보함
            GameScore currentPlayerScore =
                    playerArray[i].getGameScore();

            // 자신의 특수 주사위 번호를 바탕으로
            // 훔치기, 버프, 사망 등의 옵션 동작을 구동
            switch (currentPlayerSpecialDiceNumber) {
                case STEAL:
                    // 내 점수에 상대방 점수 훔치기
                    // 상대방 -3, 자신 +3
                    targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                    break;

                case BUFF:
                    // 자기 버프 +2
                    currentPlayerScore.addScore(BUFF_SCORE);
                    break;

                case DEATH:
                    currentPlayerScore.loseAll(DEATH_SCORE);
                    break;
            }
        }
    }

    // 플레이어 정보 출력
    public void printResult() {
        for (int i = 0; i < 2; i++) {
            System.out.println(playerArray[i]);
        }
    }

    // 승자 판정
    public void checkWinner() {
        // TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요
        // 각자의 점수 객체 확보
        GameScore firstPlayerScore = playerArray[0].getGameScore();
        GameScore secondPlayerScore = playerArray[1].getGameScore();

        // 점수 비교하여 승자 판정
        if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
            System.out.println("승자: " + playerArray[0].getName());
        } else {
            System.out.println("승자: " + playerArray[1].getName());
        }
    }
}
