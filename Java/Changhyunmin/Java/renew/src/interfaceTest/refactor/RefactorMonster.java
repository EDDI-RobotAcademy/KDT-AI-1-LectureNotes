package interfaceTest.refactor;

//상속은 재사용성을 위해서 사용하지 않습니다.
//Type Hierarchy 만들기 위해 사용합니다.

import random.CustomRandom;

//일방적인 관리 -> 위에서 아래를 관리한다?x
//타입 계층구조를 만든다는 것은 캐릭터라는 기본 스펙을 공통적으로 제공해주겠다는 뜻
//고로 캐릭터 계열의 모든 데이터 타입들은 상속된 정보들을 공통되게 사용할 수 있습니다.
//대부분 사용할 일이 없지만 혹시라도 모르니깐 알아두면 좋다
public class RefactorMonster extends CharacterModel{

    //List<Integer> integerList;
    //Collection: 정보 묶음 \\타입을 계층화하는건 가능하다.
    //Iterable: 반복

    public RefactorMonster(int statMin, int statMax, int hpMin, int hpMax) {

        super(CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(statMin, statMax),
                CustomRandom.generateNumber(hpMin, hpMax));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
