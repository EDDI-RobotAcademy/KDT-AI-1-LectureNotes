package problems.prob4;
/*
4. 54 ~ 132까지 더하는 프로그램을 만들어봅시다.
*/
public class Problem4 {

    public void addNum1ToNum2(int min, int max){
        int tmpSum = 0;
        for(int i = min; i < max+1 ; i++){
           tmpSum += i;
       }
        System.out.printf("%d부터 %d 까지의 합은 %d 입니다.%n", min, max, tmpSum);
    }


    public static void main(String[] args) {
        Problem4 problem4 = new Problem4();
        problem4.addNum1ToNum2(54, 132);


    }
}
