package Basic_Grammar;

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

        // OOP (Object Oriented Programming)
        // Domain Driven Development (DDD)

        // 잘 만든 OOP란 무엇인가 ?
        // OOP란 모든 정보를 객체화하여 레고처럼
        // 필요하면 조립하여 관리하자라는 뜻을 가지고 있습니다.

        // 하지만 모든 정보를 하나의 클래스에서 관리하게 되는 경우
        // 객체가 비대해지면서 해당 객체가 어떤 목적을 가지고 있었는지 목적성을 잃게 됩니다.
        // Domain이라는 관점은 이렇게 클래스가 어떤 주제에 집중을 하고 있는지를 본다고 생각하면 됩니다.
        // 즉 내가 집중하는 주제가 무엇인가를 알 수 있도록 예쁘게 잘 표현해주는 것을 OOP라 봐도 무방합니다.

        final Led led = new Led();

        System.out.println("현재 전구 상태 : " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
        led.setTurnOn(true);
        System.out.println("현재 전구 상태 : " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
    }
}
