package lectureClass;

class Led2 {
    private Boolean isTurnOn;
    public Led2() {
        this.isTurnOn = false;
        System.out.println("생성자 호출");
    }
    public Boolean getTurnOn() {
        return isTurnOn;
    }
    public void setTurnOn(Boolean turnOn) {
        isTurnOn = turnOn;
    }
}

public class BackupClassTest {
    public static void main(String[] args) {
        System.out.println("생성자 호출 전");
        final Led2 led = new Led2();
        System.out.println("생성자 호출 후");

        System.out.println("현재 전구 상태: " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
        led.setTurnOn(true);
        System.out.println("현재 전구 상태: " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
    }
}