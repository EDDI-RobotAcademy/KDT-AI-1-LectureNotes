package practice.firstProb1;

public class FirstProbTest1 {
    public static void main(String[] args) {
        FirstProb1 firstProb1 = new FirstProb1();
        firstProb1.printEven("짝수만 출력", 2);
        System.out.println();
        firstProb1.printEven("홀수만 출력", 3);
        System.out.println();
        firstProb1.printMultiple("3의 배수만 출력", 3);
        System.out.println();
        firstProb1.printMultiple("5의 배수만 출력", 5);
        System.out.println();
        firstProb1.printMultipleSum("4의 배수를 더한 결과를 출력", 4);
        System.out.println();
        firstProb1.printMultipleSum("6의 배수를 더한 결과를 출력", 6);
        
    }
}
