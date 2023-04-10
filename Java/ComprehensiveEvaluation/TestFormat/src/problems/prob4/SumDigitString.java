package problems.prob4;

public class SumDigitString {
    private int sum = 0;
    public SumDigitString() {
        sum = 0;
    }

    public void setSum(int min, int max) {
      for(int i = min; i <= max; i++) {
         sum += i;
      }
    }


    public int getSum() {
        System.out.println(sum);
        return sum;
    }
}
