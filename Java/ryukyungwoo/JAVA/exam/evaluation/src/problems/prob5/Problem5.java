package problems.prob5;


// 3, 3, 3, 6, 9, 12, 18, 27, 39, 57
// (n-3)+(n-1)= n

import java.util.ArrayList;
import java.util.List;

class ArithmeticSequence {
    List<Integer> arithmeticSequenceList = new ArrayList<>();

    public ArithmeticSequence () {
        arithmeticSequenceList.add(3); //i = 0
        arithmeticSequenceList.add(3); //i = 1
        arithmeticSequenceList.add(3); //i = 2

        for (int i = 3; i < 100; i++) {
//            arithmeticSequenceList.add(i); /// 3, 3, 3, 3, 4, 5 ,6 ,7, 8 ...
            arithmeticSequenceList.add(arithmeticSequenceList.get(i-1) + arithmeticSequenceList.get(i-3));
        }             //                   를 숫자 배열 리스트에 넣기     // 배열 리스트 i-1가 가지고 있는 수 + i - 3이 가지고 있는 수
    }                                                          // i = 3    i=2                              i=0    = 3+3 =6
                                                               // i = 4    i=3                              i=1    = 6+3 =9

    @Override
    public String toString() {
        return "ArithmeticSequence{" +
                "arithmeticSequenceList=" + arithmeticSequenceList +
                '}';
    }
}
public class Problem5 {
    public static void main(String[] args) {
        ArithmeticSequence arithmeticSequence = new ArithmeticSequence();
        System.out.println(arithmeticSequence);
        System.out.println("20 번째 숫자는 =" + arithmeticSequence.arithmeticSequenceList.get(20));

    }
}
