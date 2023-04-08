package customLibrary;

public class CustomSum {
    final static private int DECISION_MAKER = 0;
    public static int getSum(int START, int END) {
        int numSum = 0;
        for(int i = START; i <= END; i++) {
            numSum += i;
        }
        return numSum;
    }

    public static int getSpecialSum(int START, int END, int DECISION_NUM) {
        int numSum = 0;
        for (int i = START; i <= END; i++) {
            if (i % DECISION_NUM == DECISION_MAKER) {
                numSum += i;
            }
        }
        return numSum;
    }
}
