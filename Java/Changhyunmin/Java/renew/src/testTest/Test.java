package testTest;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        //10보다 작은 자연수 중에서 3또는 5의 배수는 3,5,6,9 이고 이것을 모두 더하면 23입니다.
        //1000보다 작은 자연수 중에서 3또는 5의 배수를 모두 더하면 얼마일까요?
        final int MAX = 1000;
        final int Three = 3;
        final int Five = 5;
        int total = 0;
        for (int i = 0; i < MAX; i++){
            if ((i % Three == 0)||(i % Five == 0)){
                System.out.println(i);
                total += i;
            }
        }
        System.out.println("최종값: " + total);

        TestClass test = new TestClass(MAX);

        final List<Integer>Ttest = test.Test_Q(Three, Five);

        System.out.println(Ttest);
        final int testSumQ = test.TestSum_Q(Three, Five);
        System.out.println(testSumQ);

    }
}
