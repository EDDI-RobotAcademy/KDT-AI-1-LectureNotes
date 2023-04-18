package examSolve.exam1.pro15;

import examSolve.exam1.customLibrary.number.NumberSequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pro15 {
    public static void main(String[] args) {

        // 숫자 배열의 시작 값(?)
        Integer[] initArr = { 1, 3 };
        // initArr 배열을 스트림으로 바꾸고, 리스트로 변환한다.
        // 그 리스트를 numberList의 생성 인자로 전달하여
        // 1, 3을 초기값으로 포함하도록 한다.
        List<Integer> numberList = new ArrayList<>(Arrays.stream(initArr).toList());
        NumberSequence pro15_numberSequence = new NumberSequence(numberList);

        final int wantIndex = 273;
        final int findValue = pro15_numberSequence.printPro15(wantIndex);
        System.out.println(findValue);
    }
}
