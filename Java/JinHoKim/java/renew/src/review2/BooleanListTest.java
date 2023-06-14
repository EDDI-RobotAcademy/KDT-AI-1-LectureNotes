package review2;

import utility.random.CustomRandom;

import java.util.ArrayList;
import java.util.List;

public class BooleanListTest {
    public static void main(String[] args) {

        List<Boolean> monsterCriticalList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Boolean isCritical = CustomRandom.generateNumber(1) == 1 ? true : false;
            monsterCriticalList.add(isCritical);

            System.out.println("Boolean 리스트 출력: " + monsterCriticalList.get(i));
        }
        
        for (int i = 0; i < 5; i++) {
            if (monsterCriticalList.get(i)) {
                System.out.println("크리티컬!!! 데미지 4배!");
            }
        }
    }
}
