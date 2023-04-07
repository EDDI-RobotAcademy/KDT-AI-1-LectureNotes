package problems.prob5;
//3, 3, 3, 6, 9, 12, 18, 27, 39, 57, …
//이 숫자 나열의 20번째엔 어떤 숫자가 있을지 프로그램을 작성

//각 나열의 차이 : (0,0,3,3,)3,6,9,12,18 - 3n씩 더하는것
//9부터 시작하는 배열로 만들어야하나?
//1~4번째항은 고정으로, 이후부터 시작하는 수열

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Problem5 {
    public static void main(String[] args) {
        // 몇번째 항까지만 배열이 나오도록 만들어야한다.
        // 1. 몇번째 항까지 모두 출력한다면
        // 앞에 4개 3,3,3,6은 배열이 나오게 한 뒤에 앞에 삽입.
        // 2. 단순히 몇번째 항만 나오게 할거라면
        // 나열된 수열식에서 몇번째 항 나오면 뒤에 +4번째 항으로 수정하여 출력
        int NUMBER = 0;
        int COUNT = 20;
        int START = 9;
        int SUM = 0;

        int i;
        for (i = NUMBER; i < COUNT - 4; i++) {
            SUM += i * 3;
        }
        System.out.println(START + SUM);
        System.out.println(COUNT + "번째항의 값");
    }
}
