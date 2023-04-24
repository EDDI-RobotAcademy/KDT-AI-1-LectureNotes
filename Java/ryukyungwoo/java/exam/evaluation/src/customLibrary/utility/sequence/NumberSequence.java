package customLibrary.utility.sequence;

import java.util.List;

public class NumberSequence implements CustomSequence {
    private int start;
    private int end;
    private int totalSum;

    private List<Integer> numberList;

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public NumberSequence(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public void addThroughout() {
        totalSum = 0;

        for (int i = start; i <= end; i++) {
            totalSum += i;
        }
    }

    public void addThroughoutWithCondition(int timesOfWant) {
        totalSum = 0;

        for (int i = start; i <= end; i++) {
            if (i % timesOfWant == 0) {
                totalSum += i;
            }
        }
    }

    public void findTimesOf(int wantToFind) {
        System.out.printf("%d ~ %d 범주내 %d의 배수를 출력합니다.\n",
                start, end, wantToFind);

        int count = 1;

        for (int i = start; i <= end; i++) {
            if (i % wantToFind == 0) {
                System.out.printf("%d, ", i);

                if (count++ % 5 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public int getTotalSum() {
        return totalSum;
    }

    @Override
    public int applyProb5Rules(int idx) {
        final int BIAS_FOR_KNOWN_VALUE = 3;

        // 3, 3, 3, 6, 9, 12, 18, 27, 39, 57,
        for (int i = 0; i < idx - BIAS_FOR_KNOWN_VALUE; i++) {
            Integer first = numberList.get(i);
            Integer third = numberList.get(i + 2);
            Integer tmpValue = first + third;

            numberList.add(tmpValue);
            System.out.printf("%d, ", tmpValue);
        }
        System.out.println();

        return numberList.get(idx - 1);
    }

    @Override
    public int applyProb15Rules(int idx) {
        final int firstTerm = numberList.get(0);
        final int commonDifference = numberList.get(1) - firstTerm;

        return firstTerm + commonDifference * (idx - 1);
    }
}
