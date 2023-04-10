package genericTest;

import rpgGame.characterModel.RefactorGameCharacter;
import rpgGame.characterModel.RefactorMonster;

import java.util.ArrayList;
import java.util.List;

class GiveMeAnything {
    // 접근제어(public) <제너락타입> 실제리턴타입 함수명 (List<제너릭타입>, int index)
    // public RefactorMonster canReturnAnything (List<RefactorMonster>, int index)
    // public RefactorGameCharacter canReturnAnything (List<RefactorGameCharacter>, int index)
    // 단점: 문법이......... 좀 괴랄하다.
    public <T> T canReturnAnyThing (List<T> inputList, int index) {
        return  inputList.get(index);
    }
}

public class GenericTest {
    public static void main(String[] args) {
        List<RefactorMonster> monsterList = new ArrayList<>();
        List<RefactorGameCharacter> characterList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            monsterList.add(new RefactorMonster(20,30,200,300));
        }

        for (int i = 0; i < 3; i++) {
            characterList.add(new RefactorGameCharacter(10,20,100,200));
        }

        GiveMeAnything giveMeAnything = new GiveMeAnything();

        System.out.println(giveMeAnything.canReturnAnyThing(monsterList, 0));
        System.out.println(giveMeAnything.canReturnAnyThing(characterList, 0));
    }
}
