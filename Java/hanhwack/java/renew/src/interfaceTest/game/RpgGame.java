package interfaceTest.game;

import interfaceTest.character.GameCharacter;
import interfaceTest.character.Monster;

import java.util.ArrayList;
import java.util.List;

public class RpgGame {
    final int CHARACTER_NUMBER = 3;
    final int MINSTER_NUM = 2;
    List<GameCharacter> gameCharacterList ;
    List<Monster> monsterList ;

    public RpgGame() {
        gameCharacterList = new ArrayList<>() ;

        for (int i = 0; i < CHARACTER_NUMBER; i++ ) {
            GameCharacter gameCharacter = new GameCharacter();
            gameCharacterList.add(gameCharacter);
        }

        monsterList = new ArrayList<>();

        for (int i = 0; i < MINSTER_NUM; i++){
            Monster monster = new Monster();
            monsterList.add(monster);
        }
    }

    public void playGame() throws InterruptedException {
        int round = 1;
        for (int i = 0; ;i++) {
            System.out.println("현재 턴: " + (round++));
            Thread.sleep(1000);

            }
        }

    @Override
    public String toString() {
        return "RpgGame{" +
                "gameCharacterList=" + gameCharacterList +
                ", monsterList=" + monsterList +
                '}';
    }
}


