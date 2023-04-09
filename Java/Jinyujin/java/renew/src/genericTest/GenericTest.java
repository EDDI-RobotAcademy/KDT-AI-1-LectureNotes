package genericTest;

import game.rpg.characterModel.RefactorGameCharacter;
import game.rpg.characterModel.RefactorMonster;

import java.util.ArrayList;
import java.util.List;

class GiveMeAnything { // 아무거나 다 주세요 - 리팩터rpg게임에서 해결 못 했던걸 할 수 있음
    // public은 접근제어자
    // 접근제어(public) <제너릭타입> 실제리턴함수명(List<제너릭타입>, int index) 형식
    // 아래는 public RefactorMonster canReturnAnyThing(List<RefactorGameCharacter>, int index)
    // public RefactorGameCharacter canReturnAnyThing(List<RefactorMonster>, int index)
    // 와 같은 말임
    // 단점: 문법이 좀 괴랄하다
    public <T> T canReturnAnyThing (List<T> inputList, int index) {// 아무거나 다 주세요 라는 의미
        // 리팩터게임에서 하려던걸 할 수 있다는 말
        return inputList.get(index);
    }
}

public class GenericTest {
    public static void main(String[] args) {
        List<RefactorMonster> monsterList = new ArrayList<>();
        List<RefactorGameCharacter> characterList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            monsterList.add(new RefactorMonster(20,30,200, 300));
        }

        for (int i = 0; i < 3; i++) {
            characterList.add(new RefactorGameCharacter(10,20,100, 200));
        }

        GiveMeAnything giveMeAnything = new GiveMeAnything();

        System.out.println(giveMeAnything.canReturnAnyThing(monsterList,1));
        System.out.println(giveMeAnything.canReturnAnyThing(characterList,0));
    }
}
