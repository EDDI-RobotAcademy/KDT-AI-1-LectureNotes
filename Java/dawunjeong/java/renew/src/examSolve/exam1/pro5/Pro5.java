package examSolve.exam1.pro5;
// 문제 5번
// 3, 3, 3, 6, 9, 12, 18, 27, 39, 57 20번째 숫자 확인

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pro5Rules{
    final int BIAS_PRO5 = 3;
    final Integer[] initArr = {3, 3, 3};
    final List<Integer> numberList = new ArrayList<>(Arrays.stream(initArr).toList());

    public Pro5Rules(int finalindex) {
        for(int i = 0; i < finalindex - BIAS_PRO5; i++){
            Integer firstNum  = numberList.get(i);
            Integer thirdNum = numberList.get(i + 2);
            Integer tmpNum = firstNum + thirdNum;
            numberList.add(tmpNum);
        }
    }

    public void findNumber(int index){
        final int BIAS_LIST = 1;
        System.out.println(numberList.get(index - BIAS_LIST));
    }
}
public class Pro5 {
    public static void main(String[] args) {

        Pro5Rules pro5Rules = new Pro5Rules(20);
        pro5Rules.findNumber(20);
    }
}
