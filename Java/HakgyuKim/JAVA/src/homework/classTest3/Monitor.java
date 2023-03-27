package homework.classTest3;

public class Monitor {

    final private String monitorProductName;
    private boolean turnOn;

    public Monitor(String monitorProductName, boolean turnOn) {
        this.monitorProductName = monitorProductName;
        this.turnOn = false;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "monitorProductName='" + monitorProductName + '\'' +
                ", turnOn=" + turnOn +
                '}';
    }
}
