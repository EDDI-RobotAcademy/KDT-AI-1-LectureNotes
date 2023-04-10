package problems.prob4;

public class Problem4 {
    public static void main(String[] args) {
        //4. 54 ~ 132까지 더하는 프로그램을 만들어봅시다.
        int Start = 54;
        int End = 132;
        int Sum = 0;
        for (int i = Start; i <= End; i++){
            Sum += i;
        }
        System.out.println(Sum);
    }
}
