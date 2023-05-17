package practice1;

import java.util.ArrayList;
import java.util.List;

public class Player { // 주사위, 총점
    final private String name;
    final private GameScore gameScore;
    final private int DiceNumber = 3;
    //final Dice[] gameDices = new Dice[3];
    final List<Dice> gameDiceList = new ArrayList<>();
    int gameDicesSum = 0;


    public Player(String name) {
        gameScore = new GameScore(gameDicesSum);
        this.name = name;
        int gameNumberSum = rollDice();
    }
    public int rollDice(){
        for ( int i =0; i<DiceNumber; i++){
            gameDiceList.add(new Dice()); //게임다이스리스트에 새로운주사위들을 추가하자
            gameDicesSum += gameDiceList.get(i).getDiceNumber();
            if (gameDiceList.get(0).getDiceNumber() % 2 == 1){ //게임다이스리스트의 첫번째 주사위 숫자가 2의배수가 아니라면
                break; //나와, 더이상의 리스트에 새로운주사위 추가는 없어
            }

        }
        return gameDicesSum; //게임다이스들의 총합을 반환해
        }
    public GameScore getGameScore(){ //게임스코어의 게임스코어 가져오기
        return gameScore;
    }
    public String getName(){ // 이름가져오기
        return name;
    }
    public Dice getSelectedGameDice(int index) {
        if(gameDiceList.size()> index){
            return gameDiceList.get(index);
            //gameDices[index];
        }return null;
    }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gameScore=" + gameScore +
                ", gameDiceList=" + gameDiceList +
                '}';
    }
}

