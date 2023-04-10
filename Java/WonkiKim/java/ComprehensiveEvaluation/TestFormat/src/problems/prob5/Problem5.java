package problems.prob5;

import customLibrary.math.SimilarFibonacci;

public class Problem5 {
    public static void main(String[] args) {
        final int count = 20;
        SimilarFibonacci similarFibonacciCalculator = new SimilarFibonacci();
        System.out.println(similarFibonacciCalculator.similarFibonacci(count));
    }
}
