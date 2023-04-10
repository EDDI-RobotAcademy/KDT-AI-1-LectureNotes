package customLibrary.prob4;

public class Sum {
    final int Min = 54;
    final int Max = 132;

    public void calculate() {
        int tmpSum = 0;
        for (int i = Min; i <= Max; i++) {
            tmpSum += i;
        }
        System.out.println("54 ~ 132까지의 합계: " + tmpSum);
    }
}
