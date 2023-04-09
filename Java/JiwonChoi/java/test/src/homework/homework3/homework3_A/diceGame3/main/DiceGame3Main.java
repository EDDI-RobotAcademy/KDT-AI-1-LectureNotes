package homework.homework3.homework3_A.diceGame3.main;

import homework.homework3.homework3_A.diceGame3.component.GameDice;
import homework.homework3.homework3_A.diceGame3.component.GameScore;
import homework.homework3.homework3_A.diceGame3.component.Player;

//친구(추후 다수의 palyer로 확장 가능성 존재)
//주사위
//점수
//게임
class ThirdDiceGame {
    final private int PLAYER_NUM = 2; //플레이 인원
    final private Player[] playerArray = new Player[PLAYER_NUM];
    // 플레이어를 관리하기 위한 배열
    // Player 클래스 배열인 playerArray는 플레이 인원만큼 공간이 있다.

    public ThirdDiceGame() { //생성자
        for (int i = 0; i < PLAYER_NUM; i++) { //ThidDiceGame()은 플레이 인원만큼 반복하며 플레이어 객체를 생성
            playerArray[i] = new Player("플레이어" + (i + 1));
            //배열 playerArray는 Player(플레이어1), Player(플레이어2),..Player(플레이어(i+1))을 요소로 한다.
            System.out.println(playerArray[i]);
            // 출력 --> Player(플레이어1), Player(플레이어2)
            // =>
        }
    }
    //플레이 인원이 2명이므로
    // playerArray = {플레이어1, 플레이어2}
    //playerArray[0] = 플레이어1
    //playerArray[1] = 플레이어2

        private int findTargetPlayerIndex ( int currentPlayerIndex){ //상대방 인덱스를 찾기 위한 매서드
            //상대편 찾기 1:1 상황
            int targetPlayerIndex = 0;

            //내가 0번이면 상대방은 1번임 (1:1이니까)
            if (currentPlayerIndex == 0) {
                targetPlayerIndex = 1;
            }

            return targetPlayerIndex;
        }

        //특수 주사위 번호 찾기
        private int findSpecialDiceNumber ( int playerIndex ){
            // 배열은 0부터 시작하므로 마지막 index는 2에 해당함
            // 배열 편향치인 1 값을 항상 빼줘야함
            final int ARRAY_BIAS = 1; //배열 편향치 1
            final int SPECIAL_DICE_INDEX = 3 - ARRAY_BIAS;
            // 특수 주사위 => 3번째 주사위 => 인덱스2 => 3 - 배열 편향치


            GameDice currentPlayerSpecialDice =
                    playerArray[playerIndex].getSelectedGameDice(SPECIAL_DICE_INDEX);
            // 플레이어 정보에서 선택한 2번 index의 GameDice 객체를 확보함

            //현재 플레이어의 3번째주사위는 =
            // 배열 playerArray[playerIndex] => 플레이어(playerIndex+1)의

            // gameDices[SPECIAL_DICE_INDEX]이다.
            // gameDices[3]
            // gameDices = {랜덤주사위값, 랜덤주사위값, 랜덤주사위값}

            // 만약 주사위를 한번 굴려서
            // null을 가져왔다면 0점을 리턴
            if (currentPlayerSpecialDice == null) { return 0; }

            // 그렇지 않다면 이 특수 주사위의 번호를 확보함
            // currentPlayerSpecialDiceNumber = currentPlayerSpecialDice를 랜덤으로 굴린 값
            int currentPlayerSpecialDiceNumber = currentPlayerSpecialDice.getDiceNumber();

            //      "      를 리턴
            return currentPlayerSpecialDiceNumber;
        }


        //게임 시작
        public void playGame () {
            //특별한 주사위 번호
            final int STEAL = 1;
            final int BUFF = 3;
            final int DEATH = 4;

            //특별한 주사위 가산값
            final int STEAL_SCORE = 3;
            final int BUFF_SCORE = 2;
            final int DEATH_SCORE = -1;

            for (int i = 0; i < PLAYER_NUM; i++) { // PLAYER_NUM=인원수= 2 만큼 반복

                int currentPlayerSpecialDiceNumber = findSpecialDiceNumber(i);
                //currentPlayerSpecialDiceNumber는 findSpecialDiceNumber(사람번호)?
                //findSpecialDiceNumber(0) = 플레이어1의 3번째 주사위 랜덤 값
                //findSpecialDiceNumber(1) = 플레이어2의 3번째 주사위 랜덤 값

                if (currentPlayerSpecialDiceNumber == 0) { continue; }
                // 0이면 동작할 필요 없으니 이 플레이어를 제낌

                //상대편 찾기 (1:1 상황)  TODO: 확장성이 떨어지므로 개선 필요
                int targetPlayerIndex = findTargetPlayerIndex(i);
                //  targetPlayerIndex  는 findTargetPlayerIndex(사람번호)?
                //상대방번호는 = findTargetPlayerIndex(0) = 1 (내가 0)
                //상대방번호는 = findTargetPlayerIndex(1) = 0 (내가 1)

                GameScore targetPlayerScore = playerArray[targetPlayerIndex].getGameScore();
                //targetPlayerScore
                //= 배열playerArray의 targetPlayerIndex번 요소의 게임스코어
                //= playerArray[상대방번호]의 게임스코어

                GameScore currentPlayerScore = playerArray[i].getGameScore();
                //currentPlayerScore
                //= 배열playerArray의 i번 요소의 게임스코어
                //i=0  -> 플레이어1의 게임스코어
                //i=1  -> 플레이어2의 게임스코어


                // 자신의 특수 주사위 번호를 바탕으로
                // 훔치기, 버프, 사망 등의 옵션 동작을 구동
                switch (currentPlayerSpecialDiceNumber) { //만약 특수주사위값이
                    case STEAL: //(주사위가)1이면
                        targetPlayerScore.takeScore(currentPlayerScore, STEAL_SCORE);
                        //currentPlayerScore에게 + STEAL_SCORE(즉 +3), targetPlayerScore에게 -3
                        //나+3, 상대방-3
                        break;

                    case BUFF://(주사위가)3이면
                        currentPlayerScore.addScore(BUFF_SCORE);
                        //currentPlayerScore에게 + BUFF_SCORE(즉 +2)
                        //나 +2
                        break;

                    case DEATH://(주사위가)4면
                        currentPlayerScore.loseAll(DEATH_SCORE);
                        //currentPlayerScore는 DEATH_SCORE (즉,-1???)
                        //나 -1???
                        break;
                }
            }
        }

        //플레이어 정보 출력
        public void printResult () {
            for (int i = 0; i < PLAYER_NUM; i++) {
                System.out.println(playerArray[i]);
            }
        }

        //승자 판정
        public void checkWinner () {
            //각자의 점수 객체 확보 -->TODO: 확장성 문제가 존재함 추후 사용자 숫자 증대시 리팩토링 필요

            GameScore firstPlayerScore = playerArray[0].getGameScore();
            //firstPlayerScore는 플레이어1의 gameScore

            GameScore secondPlayerScore = playerArray[1].getGameScore();
            //secondPlayerScore는 플레이어2의 gameScore

            if (firstPlayerScore.getTotalScore() > secondPlayerScore.getTotalScore()) {
                //플레이어1의 totalScore > 플레이어2의 totalScore면
                System.out.println("승자: " + playerArray[0].getName());
                // 출력-->> 승자: 플레이어1의 이름
            } else { //그게 아니면
                System.out.println("승자: " + playerArray[1].getName());
                // 출력-->> 승자: 플레이어2의 이름
            }
        }
    }


public class DiceGame3Main {
    public static void main(String[] args) {
        ThirdDiceGame game = new ThirdDiceGame();
        System.out.println();
        System.out.println("<< 점수 판정 이후 >>");
        game.playGame();
        game.printResult();
        game.checkWinner();
    }
}
