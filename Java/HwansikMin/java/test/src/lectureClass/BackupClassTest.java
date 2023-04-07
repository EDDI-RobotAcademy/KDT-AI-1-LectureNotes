package lectureClass;

class Led2 {
    private Boolean isTurnOn;
    public Led2() {
        this.isTurnOn = false;
        System.out.println("생성자 호출");
    }
    // Getter는 class 내에서 다루는 정보를 얻기 위해 사용합니다.
    public Boolean getTurnOn() {
        return isTurnOn;
    }
    // Settersms class 내에서 다루는 정보를 직접 설정하는 목적으로 사용합니다.
    public void setTurnOn(Boolean turnOn) {
        isTurnOn = turnOn;
    }
}

public class BackupClassTest {
    public static void main(String[] args) {
        System.out.println("생성자 호출 전");
        // 왜 데이터 타입을 적는 곳에 class 이름이 오는 것이지 ?
        // A : 클래스라는 것 자체가 커스텀 데이터 타입이기 때문입니다.
        //     여러분이 직접 커스텀 할 수 있는 데이터 타입이 클래스라 보면 됩니다.
        final Led2 led = new Led2();            // <- 초기 생성 (꺼짐 - isTurnOn: false)
        System.out.println("생성자 호출 후");

        System.out.println("현재 전구 상태: " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
        led.setTurnOn(true);                  // <- 상태 변경 (켜짐 - isTurnOn: true)
        System.out.println("현재 전구 상태: " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
    }
}