package lectureClass;

// Led Class는 불이 켜졌다 꺼졌다만 관리하면 됨
// class의 형태
/*
-----Led 객체 ----
|   isTurnOn    |
-----------------
|   Led 생성자   |   << new를 하면 이와 같은 형태가 만들어짐
|   getTurnOn   |
|   setTurnOn   |
-----------------
 */
class Led{
    private Boolean isTurnOn;
//    alt + insert 생성자
//    public Led() {
//        this.isTurnOn = false;
//    }
//    alt + insert getter 및 setter
//    public Boolean getTurnOn() {
//        return isTurnOn;
//    }
//    생성자는 class의 이름과 같고 리턴 타입이 없음
//    1. public을 적고 class 이름을 적은 이후 ()를 작성후 {}를 작성합니다.
//    2. 외부에서 값을 입력 받을 것이라면 ()에 입력받을 형태를 작성
//    3. 실제 class가 new를 통해 객체화 될 때 구동시키고 싶은 작업을 {}안에 배치

    public Led() {
        this.isTurnOn = false;
    }
//    class 내부에 기능을 수행하는 집합들을 매서드라고 부릅니다.
//    매서드 작성 방법
//    1. public을 작성하고 ()를 작성하고 {}작성
//    2. 리턴 타입을 public 옆에 작성
//    3. 매서드의 이름을 그 옆에 작성
//    4. {}안에 실제 매서드 이름에 해당하는 작업을 진행
//       이 때 단순히 작업만 하고 정보 반환이 없다면(하지않는 다면)리턴 타입은 void
//       참/거짓을 반환한다면 Boolean
//       숫자등등이라면 Long(long)이나 Integer(int), 문자열이면 string
//       무엇을 반환 하느냐에 따라 적절한 형태로 작성

    public Boolean getisTurnOn() {
        return isTurnOn;
    }
//    전구는 자신 스스로 킬 수 없기 때문에 다른 객체의 도움을 받아야함
//    수십년간의 sw 전문가들이 이러한 개념들을 정리하였고 일환으로 탄생한 개념이 Domain Service 개념이다
//    비즈니스 관점을 좀 더 명확하게 만들어준다는 이점이 있음
//    전구를 Domain Service로 나눠 본다면 키기, 끄기, 깜빡이기
//    Domain Service는 객체가 스스로 하기에는 어려운 작업을 Domain Service로 재배치하여
//    가독성과 유지보수성을 향상시킬 수 있음

//    제어하는 Controller에 RequestForm 객체를 전달
//    RequestForm 객체는 Domain Service에서 처리하기 적합한 형태인 Request로 변환
//    그리고 Request를 보고 적절한 Entity를 추출하게 되는데
//    이런 관점으로 접근하면 setter를 완벽하게 제거 가능
//    필요하면 final 객체에 final 변수들을 설정해서 전달한다는 의미

    public void setTurnOn(Boolean turnOn) {
        isTurnOn = turnOn;
    }
}
public class LectureClassTest {
    public static void main(String[] args){
        //OOP (Object Oriented Programming)
        //OOP란 모든 정보를 객체화하여 레고처럼 필요하면 조립하여 관리하자는 뜻
        //하지만 모든 정보를 하나의 클래스에서 관리하게 되는 경우
        //객체가 비대해지면서 해당 객체가 어떤 목적을 가지고 있었는지 목적성을 잃게 됩니다.
        //Domain이라는 관점은 이렇게 클래스가 어떤 주제에 집중을 하고 있는지를 본다고 생각하면 됩니다.
        //즉 내가 집중하는 주제가 무엇인가를 알 수 있도록 예쁘게 잘 표현해주는 것을 OOP라 봐도 무방
        //DDD (Domain Driven Development)

//        왜 데이터 타입을 적는 곳에 class가 오는지
//        -> class라는 것 자체가 커스텀 데이터 타입이기 때문
        final Led led = new Led();    // <-초기 생성(꺼짐 - isTurnOn : false)
        System.out.println("생성자 호출 후");
        System.out.println("현재 전구 상태: " + (led.getisTurnOn() ? "켜짐" : "꺼짐"));
        led.setTurnOn(true);           // <- 상태 변경(켜짐 - isTurnOn : true)
        System.out.println("현재 전구 상태: " + (led.getisTurnOn() ? "켜짐" : "꺼짐"));
    }
}
