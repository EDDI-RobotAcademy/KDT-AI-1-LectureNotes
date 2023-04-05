package practice.basic2.number;

public class SumNumber {
    final private int minNumber;
    final private int maxNumber;
    final private int drainageNumber;
    private int sumNumber;

    public int getSumNumber() {
        return sumNumber;
    }

    public SumNumber (int minNumber, int maxNumber, int drainageNumber) {
    this.minNumber = minNumber;
    this.maxNumber = maxNumber;
    this.drainageNumber = drainageNumber;

    for (int index = minNumber; index <= maxNumber; index++) {
        if (index % drainageNumber == 0) {
            this.sumNumber += index;
            System.out.println(index);
        }
    }

}
}
