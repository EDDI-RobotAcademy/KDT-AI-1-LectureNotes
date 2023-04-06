package diceGame.player;

import diceGame.game.Dice;
import diceGame.game.GameScore;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private int MAX_DICE_NUM = 3;
    final private String name;
    final private List<Dice> gameDiceList = new ArrayList<>();
    final private GameScore gameScore;

    public Player(String name) {
        this.name = name;

        // 플레이어는 생성되면서 주사위를 굴린다.
        int diceNumberSum = rollDice();
        // 생성된 주사위의 합산 결과를 받아와서 바로 객체 생성
        gameScore = new GameScore(diceNumberSum);
    }

    private int rollDice() {
        final int FIRST_DICE_INFO = 0;
        final int DECISION_EVEN = 2;
        final int ODD = 1;

        int diceNumberSum = 0;

        for (int i = 0; i < MAX_DICE_NUM; i++) {
            gameDiceList.add(new Dice()); // 주사위 객체 생성

            diceNumberSum += gameDiceList.get(i).getDiceNumber();
            // 각 주사위를 가져와서 합산해줌

            if(gameDiceList.get(FIRST_DICE_INFO).getDiceNumber() % DECISION_EVEN == ODD){
                break;
            }
        }

        return diceNumberSum;
    }

    public Dice getSelectedGameDice(int index) {
        // 유효성 검사 필요
        if(gameDiceList.size() > index){
            return gameDiceList.get(index);
        }
        return null;
    }

    public GameScore getGameScore() {
        return gameScore;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameDiceList=" + gameDiceList +
                ", gameScore=" + gameScore +
                '}';
    }
}