package practice.basic2.number;

public class SelectionAndDrainage {
    final private int minNumber;
    final private int maxNumber;
    final private int drainageNumber;
    private int selectedNumber;

    public SelectionAndDrainage (int minNumber, int maxNumber, int drainageNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.drainageNumber = drainageNumber;

        for (int index = minNumber; index <= maxNumber; index++) {
            if (index % drainageNumber == 0) {
                this.selectedNumber = index;
                System.out.println(index);
            }
        }
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    @Override
    public String toString() {
        return "SelectionAndDrainage{" +
                "selectedNumber=" + selectedNumber +
                '}';
    }
}
