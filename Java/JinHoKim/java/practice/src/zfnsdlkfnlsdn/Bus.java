package zfnsdlkfnlsdn;

public class Bus {
    int busNumber;
    int busIncome;
    int passengerCount;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }

    public void take(int busIncome) {
        this.busIncome += busIncome;
        passengerCount++;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber=" + busNumber +
                ", busIncome=" + busIncome +
                '}';
    }
}
