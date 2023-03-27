package homework.fourth.monitor;

import java.util.Scanner;

public class MonitorTest {
    public static void main(String[] args) {
        Monitor lgMonitor = new Monitor("LG", true);
        lgMonitor.showInfo();

        System.out.println("모니터 브랜드와 false, true 를 기입해주세요 > (enter)");
        Scanner scan = new Scanner(System.in);
        String monitorBrand = scan.nextLine();
        boolean monitorPower = scan.nextBoolean();

        Monitor scanMonitor = new Monitor(monitorBrand, monitorPower);
        scanMonitor.showInfo();

    }
}
