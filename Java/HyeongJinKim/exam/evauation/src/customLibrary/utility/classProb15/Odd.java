package customLibrary.utility.classProb15;

public class Odd {
    int result;
    int count = 0;

    public Odd(int result) {
        this.result = searchTarget(result);
    }

    public int searchTarget (int target) {
        for (int i = 0; true; i++) {
            if (i % 2 == 1) {
                count++;
                if (target == count) {
                    return i;
                }
            }
        }
    }

    public int getResult() {
        return result;
    }
}
