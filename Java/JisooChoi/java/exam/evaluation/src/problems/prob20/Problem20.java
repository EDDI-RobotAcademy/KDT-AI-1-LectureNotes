package problems.prob20;

public class Problem20 {
    public static void main(String[] args) {
        final int MAX = 100;
        final int MIN = 1;

        int randomNum = (int)(Math.random() * MAX - MIN +1) + MIN;

        System.out.println("1 ~ 100까지의 랜덤 수: "+randomNum);

    }
}
