package examPractice;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

// 3. “A”, “B”, “C”, “D”, “E”, “F”, “G”, “H”, “I”, “J”
// 문자열 10개를 리스트에 넣고 랜덤으로 출력해봅시다.
public class Prob3 {
    public static void printRandomCharacterList(List<Character> characterList) {
        // 같은 클래스 위에 메서드를 생성 - 랜덤캐릭터를 프린트하라는 메서드
        // 매개변수로 리스트 변수를 넣어줌

        final int LIST_BIAS  = 1;
        // 리스트의 길이를 맞춰주기 위함

        final int LOOP_NUMBER = 5;
        // 루프 5번까지 돌아라
        for (int i = 0; i <LOOP_NUMBER; i++) {
            final int randomIndex = CustomRandom.generateNumber(
                    characterList.size() - LIST_BIAS);
            // 랜덤인덱스는 캐릭터리스트 길이만큼 랜덤으로 5번 돌아라
            // 아직 캐릭터리스트 초기화 되어 있지 않은 상태이기 때문에
            // 어떤 리스트 내용을 5번 반복해야 할지 모름

            System.out.println(characterList.get(randomIndex));
            // 캐릭터리스트에서 랜덤인덱스를 출력해라
            // for문으로 인해 5개의 랜덤인덱스가 출력된다
        }
    }

    public static void main(String[] args) {
        char storeCharacter = 'A'; // char 타입으로 storeCharacter 변수 초기화
        final List<Character> characterList = new ArrayList<>();
        // 캐릭터 타입의 캐릭터리스트 초기화
        for (int i = 0; i < 10; i++) {
            characterList.add((char)(storeCharacter + i));
        } // 캐릭터리스트에 storeCharacter 10가지 for 문으로 돌려서 10가지 추가하기
        // 이렇게 하면 ABC... 순서대로 저장이 되나봄

        printRandomCharacterList(characterList);
    }
}
