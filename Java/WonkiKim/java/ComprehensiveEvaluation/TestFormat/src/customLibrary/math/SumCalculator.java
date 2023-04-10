package customLibrary.math;

public class SumCalculator{

    public int summation(int start, int end) {
        int summationZeroToStart = (start-1) * (start) /2;
        int summationZeroToEnd = (end)*(end+1) /2;
        return summationZeroToEnd-summationZeroToStart;
    }
}
