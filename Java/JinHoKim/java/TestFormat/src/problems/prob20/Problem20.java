package problems.prob20;

import customLibrary.prob20.RandomPrint;
import customLibrary.utility.CustomRandom;

public class Problem20 {
    public static void main(String[] args) {
        //랜덤 숫자가 출력되도록 프로그램작성 문제 2번
        // 연봉 인상률 1% ~ 50%퍼 까지 랜덤 숫자 뽑기
        System.out.println(CustomRandom.generateNumber(1, 50));
    }
}
