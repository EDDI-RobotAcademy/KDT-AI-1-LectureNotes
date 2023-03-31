package practice.chapter6;

public class Bus {
    int busNumber;
    int passengerCount;
    int busIncome;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }

    public void take(int busIncome) {
        passengerCount++;
        this.busIncome = busIncome;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNumber=" + busNumber +
                ", passengerCount=" + passengerCount +
                ", busIncome=" + busIncome +
                '}';
    }
}
