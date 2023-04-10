package problems.prob5;


public class Problem5 {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 3;
        int num3 = 3;
        int num = 0;


        for (int i = 4; i < 20; i++) {
            num = num1 + num3;
            System.out.println(num);
            num2 = num3;
            num3 = num;
        }
    }
}
