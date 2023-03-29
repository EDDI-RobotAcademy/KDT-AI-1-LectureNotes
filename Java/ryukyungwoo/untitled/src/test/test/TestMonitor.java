package test.test;

class Monitor {
    final private String monitorOnOff;
    final private String monitorBrandName;

    public Monitor(String monitorOnOff, String monitorBrandName) {
        this.monitorOnOff = monitorOnOff;
        this.monitorBrandName = monitorBrandName;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "monitorOnOff='" + monitorOnOff + '\'' +
                ", monitorBrandName='" + monitorBrandName + '\'' +
                '}';
    }
}
public class TestMonitor {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("켜짐", "삼성");
        System.out.println(monitor);
    }
}