package basicProblem.classBasicProblem;

public class OneHundredMultiple {

    final int END = 100;


    public void multiple(int multipleNumber) {
        for (int i = 1; i <= END; i++){
            if (i % multipleNumber == 0){
                System.out.print(i + " ");
            }
        }
    }

    public void multipleSum(int multipleNumberSum) {

        int multipleSum = 0;

        for (int i = 1; i <= END; i++){
            if (i % multipleNumberSum == 0){
                multipleSum += i;
                System.out.print(i + " + ");
            }
        }
        System.out.println();
        System.out.println(multipleNumberSum + "의 배수 총 합은 " + multipleSum + " 입니다.");
    }
}
