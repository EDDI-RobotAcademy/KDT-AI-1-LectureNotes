
    class Led {
        private Boolean isTurnOn;

        public Led() {
//            this.isTurnOn = isTurnOn;
            this.isTurnOn = false;
        }


        public Boolean getTurnOn() {
            return isTurnOn;
        }

        public void setTurnOn(Boolean turnOn) {
            isTurnOn = turnOn;
        }
    }
// alt + insert 누르면 getter setter 만들 수 있는 창 나온다.

    public class LectureClassTest {


    public static void main(String[] args) {

        final Led led = new Led();

        System.out.println("현재 전구 상태 : " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
        led.setTurnOn(true);
        System.out.println("현재 전구 상태 : " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
    }
}
