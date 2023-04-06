package homework.basicProblem.complexProblem;

public class AppleCount {
    final int MIN = 3;
    final int MAX = 5;
    final int appleCount;

    public AppleCount(){
        this.appleCount = (int)(Math.random() * (MAX-MIN+1)) + MIN;
    }

    public int getAppleCount() {
        return appleCount;
    }
}
