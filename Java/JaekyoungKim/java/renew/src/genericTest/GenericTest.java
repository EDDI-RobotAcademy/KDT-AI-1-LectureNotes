package genericTest;

import rpg.characterModel.RefactorGameCharacter;
import rpg.characterModel.RefactorMonster;

import java.util.ArrayList;
import java.util.List;

class GiveMeAnything{
    //접근제어<public>  <타입> 실제리턴 타입 함수명 (List<제네릭타입>, int index)
    // public RefactorMonster canReturnAnyThing(List<RefactorMonster>, int index)
    // public RefactorGameCharacter canReturnAnyThing(List<RefactorGameCharacter>, int index)
    // 단점: 문법이 괴랄하다.
    public <T> T canReturnAnyThing(List<T> inputList, int index){
        return inputList.get(index);
    }
}
public class GenericTest {
    public static void main(String[] args) {
        List<RefactorMonster> monstersList=new ArrayList<>();
        List<RefactorGameCharacter> gameCharacterList=new ArrayList<>();
        for (int i=0;i<2;i++){
            monstersList.add(new RefactorMonster(10,20,100,200));

        }
        for (int i=0;i<2;i++){
            gameCharacterList.add(new RefactorGameCharacter(10,20,100,200));

        }
        GiveMeAnything giveMeAnything=new GiveMeAnything();
        System.out.println(giveMeAnything.canReturnAnyThing(monstersList,1));
        System.out.println(giveMeAnything.canReturnAnyThing(gameCharacterList,0));

    }
}
