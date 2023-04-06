package homework.homework6.diceGame5Ver2.game5;
import utility.random.CustomRandom;
import java.util.ArrayList;
import java.util.Arrays;
import static homework.homework6.diceGame5Ver2.game5.Dice.diceCount;
import static homework.homework6.diceGame5Ver2.game5.Dice.rollDice;


public class Game {
    static ArrayList<Player> playerList = new ArrayList<>();

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    static void sumDices(ArrayList<Player> playerList) {
        int sumDicesScore = 0;

        for (int i = 0; i < playerList.size(); i++) {
            int startScore = 0;
            playerList.get(i).setPlayerScore(new Score());

            for (int j = 0; j < diceCount; j++) {
                startScore += playerList.get(i).getDiceArray()[j].getDiceNumber(); //플레이어1의 1번주사위+2번주사우;..+
                sumDicesScore = startScore;
            }
            playerList.get(i).getPlayerScore().setBeforeScore(sumDicesScore);//플레이어1의 스코어의 비포스코어에 저장
        }
    }

    static public void playerAdd(String playerName) { //플레이어 이름입력하면
        Player player = new Player(playerName);
        playerList.add(player);//그 이름을 가진 플레이어 객체를 생성 + List에 추가
    }

    static void rollThreeDices(ArrayList<Player> playerList) { //해당 플레이 리스트의 모두가 주사위를 세번씩 굴림
        for (int i = 0; i < playerList.size(); i++) { //<[주사위][][]> <[][][]> <[][][]>...<[][][]>
            playerList.get(i).setDiceArray(rollDice());

            int firstDiceNumber = playerList.get(i).getDiceArray()[0].getDiceNumber();
            if (firstDiceNumber % 2 != 0) {
                for (int j = 1; j < diceCount; j++) {
                    playerList.get(i).getDiceArray()[j].setDiceNumber(0);
                }
            }
        }
    }

    public static void findTargetPlayer(Player player) {  //타겟 플레이어 찾기

        int TargetIndex = 0;
        boolean a = true;   //변수 이름 뭘로...?

        for (; a; ) {
            int randomIndexNumber = CustomRandom.generateNumber(playerList.size() - 1);
            if (player != playerList.get(randomIndexNumber)) { //타겟플레이어가 본인이 아닐때까지 반복
                a = false;
                TargetIndex = randomIndexNumber;
            } else {
                a = true;
            }
        }


        Player target = playerList.get(TargetIndex);
        String targetName = target.getPlayerName();

        player.setTargetName(targetName);
        player.setTargetIndex(TargetIndex);
    }


    static void finalScore() {
        for (int i = 0; i < playerList.size(); i++) {
            switch (playerList.get(i).getDiceArray()[2].diceNumber) {

                case 1:
                    int targetPlayerIndex = playerList.get(i).targetIndex;
                    Player targetPlayer = playerList.get(targetPlayerIndex);
                    int getscoreSum3 = playerList.get(i).getPlayerScore().beforeScore + 3;
                    int target_LoseScoreSum3 = targetPlayer.getPlayerScore().beforeScore - 3;

                    playerList.get(i).getPlayerScore().setFinalScore(getscoreSum3);
                    targetPlayer.getPlayerScore().setFinalScore(target_LoseScoreSum3);
                    break;

                case 3:
                    int scoreSum2 = playerList.get(i).getPlayerScore().beforeScore + 2;
                    playerList.get(i).getPlayerScore().setFinalScore(scoreSum2);
                    break;

                case 4:
                    int loseAllScore = -99;
                    playerList.get(i).getPlayerScore().setFinalScore(loseAllScore);
                    break;

                default:
                    int scoreSumNothing = playerList.get(i).getPlayerScore().beforeScore;
                    playerList.get(i).getPlayerScore().setFinalScore(scoreSumNothing);
                    break;
            }
        }
    }

    static void winnerCheck() {

        //파이널스코어만 오름차순으로 정렬한 배열
        //배열 마지막 요소와 같은 점수인 애들이 승자..
       int[] scoreList = new int[playerList.size()];
        for (int i = 0; i < playerList.size(); i++) {
            scoreList[i] = playerList.get(i).getPlayerScore().getFinalScore();
        }
        Arrays.sort(scoreList);
        int winnerScore = scoreList[playerList.size()-1];

        System.out.print("승자는 ");

        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getPlayerScore().getFinalScore() == winnerScore) {
                System.out.print("<" + playerList.get(i).getPlayerName() + ">");
         }
        }
        System.out.print("입니다.");
    }
}