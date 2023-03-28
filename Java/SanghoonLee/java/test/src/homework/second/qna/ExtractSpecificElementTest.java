package homework.second.qna;

import utility.random.CustomRandom;

import java.util.Arrays;

class TestArray {

    final private int ARRAY_SIZE = 7;
    final private int[] numberArray;

    final private int MIN = 5;
    final private int MAX = 13;

    public TestArray() {
        numberArray = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            numberArray[i] = CustomRandom.generateNumber(MIN, MAX);
        }
    }

    public int getSpecificElement (int index) {
        if (index < ARRAY_SIZE) {
            return numberArray[index];
        }

        System.out.println("허용하는 인덱스 범주를 초월하였습니다!");
        return 0;
    }

    @Override
    public String toString() {
        return "TestArray{" +
                "numberArray=" + Arrays.toString(numberArray) +
                '}';
    }
}
// 질문: 배열에서 딱 하나의 인자만 출력할 수 있나요?
public class ExtractSpecificElementTest {
    public static void main(String[] args) {
        TestArray testArray = new TestArray();
        System.out.println("전체 요소 확인: " + testArray);
        System.out.println(testArray.getSpecificElement(2));
    }
}
