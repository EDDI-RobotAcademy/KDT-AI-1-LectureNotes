package problems.prob6;

public class Problem6 {
    public static void main(String[] args) {
        final int multiplesOfFive = 5;
        final int MIN = 50;
        final int MAX = 100;

        for(int i=MIN; i<=MAX; i++){
            if(i % multiplesOfFive == 0){
                System.out.println(i);
            }
        }
    }
}
