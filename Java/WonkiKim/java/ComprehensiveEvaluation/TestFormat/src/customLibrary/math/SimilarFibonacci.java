package customLibrary.math;

public class SimilarFibonacci {
    public int similarFibonacci(int n) {
        if(n==1 || n==2 || n==3) {
            return 3;
        }
        return similarFibonacci(n-1) + similarFibonacci(n-3);
    }
}
