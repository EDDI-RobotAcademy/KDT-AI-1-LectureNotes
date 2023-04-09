package homework.basicProblem;

public class Problem3 {
    public static void main(String[] args) {
        final int MAX = 100;
        int sum = 0;
        for(int i=1; i<=MAX; i++){
            if(i % 4 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
