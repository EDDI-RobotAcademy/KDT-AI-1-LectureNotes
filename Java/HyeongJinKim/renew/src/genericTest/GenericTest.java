package genericTest;

import game.rpg.refactorRpgGame.characterModel.RefactorGameCharacter;
import game.rpg.refactorRpgGame.characterModel.RefactorMonster;

import java.util.ArrayList;
import java.util.List;

class GiveMeAnything {
    // 접근제어(public) <제너릭타입> 실제리턴타입 함수명 (List<제너릭타입>, int index)
    // public RefactorMonster canReturnAnyThing (List<RefactorMonster>, int index)
    // public RefactorGamePlayer canReturnAnyThing (List<RefactorGamePlayer>, int index)
    // 단점: 문법이 좀 괴랄하다.
    public <T> T canReturnAnything (List<T> inputList, int index) {
        return inputList.get(index);
    }
}

public class GenericTest {
    public static void main(String[] args) {
        List<RefactorMonster> monsterList = new ArrayList<>();
        List<RefactorGameCharacter> characterList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            monsterList.add(new RefactorMonster(20, 30, 200, 300));
        }
        for (int i = 0; i < 3; i++) {
            characterList.add(new RefactorGameCharacter(10, 20, 100, 200));
        }

        GiveMeAnything giveMeAnything = new GiveMeAnything();

        System.out.println(giveMeAnything.canReturnAnything(monsterList, 1));
        System.out.println(giveMeAnything.canReturnAnything(characterList, 0));
    }
}
