package utility.sequence;

import java.util.List;

public class NumberSequence implements CustomSequence {
    // 먼저 4번 문제 푸시면서 넘버시퀀스 클래스 만드시고
    // 다음 문제들에 맞춰서 인터페이스를 첨가하신 것 같음
    private int start;
    private int end;
    private List<Integer> numberList;

    public NumberSequence(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public NumberSequence(List<Integer> numberList) {
        this.numberList = numberList;
    }

    public void addThrougout() {
        int numberSum = 0;

        for (int i = start; i <= end; i++) {
            numberSum += i;
        }

        System.out.println(start + "부터 " + end + "까지 더한 값은  " + numberSum);
    }

    @Override
    public int applyProb5Rules(int idx) {
        final int BIAS_FOR_KNOWN_VALUE = 3;

        for (int i = 0; i < idx - BIAS_FOR_KNOWN_VALUE; i++) {
            Integer fisrt = numberList.get(i);
            Integer third = numberList.get(i + 2);
            Integer tmpvalue = fisrt + third;

            numberList.add(tmpvalue);
            System.out.printf("%d, ", tmpvalue);
        }
        System.out.println();

        return numberList.get(idx - 1);
    }

    @Override
    public int applyProb15Rules(int idx) {
        return 0;
    }
}
