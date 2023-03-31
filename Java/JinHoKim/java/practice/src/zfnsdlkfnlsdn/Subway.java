package zfnsdlkfnlsdn;

public class Subway {
    int subwayNumber;
    int subwayIncome;
    int passengerCount;

    public Subway(int subwayNumber) {
        this.subwayNumber = subwayNumber;
    }

    public void take(int subwayIncome) {
        this.subwayIncome += subwayIncome;
        passengerCount++;
    }

    @Override
    public String toString() {
        return "Subway{" +
                "subwayNumber=" + subwayNumber +
                ", subwayIncome=" + subwayIncome +
                '}';
    }
}
