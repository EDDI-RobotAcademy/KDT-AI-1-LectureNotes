package problems.prob15;

// 1,3,5,7,8,11,13, ... 이 수열의 263번째 값을 구해보세요
public class Problem15 {
    public static void main(String[] args) {
        int[] numberList = new int[263];
        numberList[0] = 1;
        numberList[1] = 3;
        numberList[2] = 5;

        for (int i = 3; i < 263; i++) {
            numberList[i] = numberList[i - 1] + 2;
        }
            System.out.println("263번째 숫자는: " + numberList[262]);
    }
}
