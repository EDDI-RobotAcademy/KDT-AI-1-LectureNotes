package practice.basic2.number;
class Two {
    private int wantTwo;
    public Two () {
        SelectionAndDrainage selectionAndDrainage = new SelectionAndDrainage(1, 100, 2);
        this.wantTwo = selectionAndDrainage.getSelectedNumber();
    }

    @Override
    public String toString() {
        return "Two{" +
                "two=" + wantTwo +
                '}';
    }
}
class Three {
    private int wantThree;
    public Three () {
        SelectionAndDrainage selectionAndDrainage = new SelectionAndDrainage(1, 100, 3);
        this.wantThree = selectionAndDrainage.getSelectedNumber();
    }

    @Override
    public String toString() {
        return "Three{" +
                "three=" + wantThree +
                '}';
    }
}
class Four {
    private int wantFour;
    private int fourSum;
    public Four () {
        SelectionAndDrainage selectionAndDrainage = new SelectionAndDrainage(1, 100, 4);
        this.wantFour = selectionAndDrainage.getSelectedNumber();
        SumNumber sumNumber = new SumNumber(1, 100, 4);
        this.fourSum = sumNumber.getSumNumber();
    }

    public int getFourSum() {
        return fourSum;
    }

    @Override
    public String toString() {
        return "Four{" +
                "wantFour=" + wantFour +
                ", fourSum=" + fourSum +
                '}';
    }
}

public class Qed {
    public static void main(String[] args) {
        Two two = new Two();
        System.out.println(two);
        Three three = new Three();
        System.out.println(three);
        Four four = new Four();
        System.out.println(four);
        System.out.println(four.getFourSum());
    }
}
