package customLibrary.prob4;

public class PlusCalculator {
    final private int startNum;
    final private int endNum;

    public PlusCalculator(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    public int addNum(){
        int addNumSum = 0;

        for(int i = this.startNum; i <= this.endNum; i++){
            addNumSum += i;
        }
        return addNumSum;
    }
}
