package practice.chapter6;

public class Subway {
    int lineNumber;
    int passengerCount;
    int lineIncome;

    public Subway(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void take(int money) {
        passengerCount++;
        this.lineIncome += money;
    }

    @Override
    public String toString() {
        return "Subway{" +
                "lineNumber=" + lineNumber +
                ", passengerCount=" + passengerCount +
                ", lineIncome=" + lineIncome +
                '}';
    }
}
