package lectureClass;

// Led 클래스는 불이 켜졌다, 꺼졌다만 관리하면 됨
// 클래스의 형태
/*
    ------- Led 객체 ------
    |      isTurnOn      |
    ----------------------
    |      LED 생성자    | < new를 하면 이와 같은 형태로 생성
    |      getTurnOn     |
    |      setTurnOn     |
    ----------------------
*/
class Led {
    private Boolean isTurnOn;

    // 생성자는 class의 이름과 같음
    // 그리고 아래와 같이 리턴 타입이 없음
    // 규칙
    // 1. public을 적고 클래스 이름을 적은 후 소괄호() 작성
    // 2. 만약 외부에서 값을 입력 받을 것이라면 소괄호에 입력받을 형태 작성
    // 3. 실제 클래스가 new를 통해 객체화 될 때 구동시키고 싶은 작업을
    //    중괄호{} 내부에 배치
    //    즉 현재는 new를 통해 만들어질 때 기본값으로 전구를 꺼놓은 상태로 시작하게 작성됨
    public Led() {
        this.isTurnOn = false;
    }

    // 클래스 내부에 기능을 수행하는 집합들을 매서드라고 부름
    // 매스더 작성법
    // 1. public 리턴타입 매서드이름 () {} 순서로 작성
    // 2. 매서드이름은 무슨 작업을 하는지 명시적으로 알려줄 수 있는 형태가 좋음
    // 3. 중괄호 내에서는 실제 매스더이름에 해당하는 작업을 작성
    //    단순히 작업만 하고 정보 반환이 없다면 리턴타입은 void
    //    참/거짓 반환시 Boolean(boolean)
    //    숫자 등등이라면 Long(long)이나 Integer(int)
    //    반환하는 형태에 따라 적절한 형태를 작성

    //        3 -> [    ] -> 9 (리턴 타입 int)
    // 버튼누름 -> [    ] -> ture (리턴 타입 boolean)
    //        1 -> [    ] -> "예금" (리턴 타입 String)
    // 회원정보 -> [    ]  (리턴 타입 void) == 리턴하지 않음을 의미
    //             [    ] -> 20 (리턴 타입 int)
    public Boolean getTurnOn() {
        return isTurnOn;
    }

    // 사실은 자기 스스로 켤 수 없기때문에 다른 객체의 도움을 받아야함
    // 수십년간의 SW 전문가들이 이러한 개념들을 정리했고
    // 그 개념의 일환으로 탄생하게 된 개념이 Domain Service 개념
    // Domain Service를 만들어서 얻는 이점은
    // 비즈니스 관점을 좀 더 명확하게 만들어준다는 점
    // 실제로 전구를 키고 끄는 작업을 가지고 비즈니스를 할만한 것들이 많지는 않지만
    // 그래도 Domain Service를 나눠 본다면 아래와 같은 것들이 존재할 것
    // 켜기, 끄기, 깜빡이기 등

    // 조금 쉽게 접근해보자면 Domain Service는
    // 객체 스스로가 직접 하기에는 표현이 애매해지는 작업들을
    // 모두 Domain Service로 재배치하게 됨
    // 이를 통해 가독성과 유지보수성의 향상을 가져올 수 있음

    // 제어하는 Controller에 RequestForm 객체 전달
    // RequestForm 객체는 Domain Service에서 처리하기 적합한 형태의 Request로 변환
    // 그리고 Request를 보고 적절한 Entity를 추출하게 되는데
    // 이런 관점으로 접근하면 setter를 완벽하게 제거 할 수 있음
    // 즉 필요하면 final 객체에 final 변수들을 설정해서 전달한다는 의미

    // * 입력 관점에서 살펴보기
    //        3 -> [    ] -> 9 (입력 타입 int)
    // 버튼누름 -> [    ] -> ture (입력 타입 Button class)
    //        1 -> [    ] -> "예금" (입력 타입 int)
    //             [    ] -> 20 (입력 타입 void)
    //  참/거짓 -> [    ] (입력 타입 boolean)
    public void setTurnOn(Boolean turnOn) {
        isTurnOn = turnOn;
    }
}

public class LectureClassTest {
    public static void main(String[] args) {
        // DDD ( Domain Driven Development)
        // OOP (Object Oriented Programming) 객체지향 프로그래밍
        // 모든 정보를 객체화하여 레고처럼 필요할때 조립하여 관리하자라는 뜻
        // 하지만 모든 정보를 하나의 클래스에서 관리하게 되는 경우
        // 객체가 비대해면서 해당 객체가 어떤 목적을 가지고 있었는지 목적성을 잃게 됨
        // Domain이라는 관점은 이렇게 클래스가 어떤 주제에 집중을 하고 있는지 본다고 생각하면 됨
        // 즉 내가 집중하는 주제가 무엇인가를 알 수 있도록
        // 예쁘게 잘 표현해주는 것을 OOP라 봐도 무방함

        // 잘 만든 OOP란 무엇인가 ?
        // 전구를 키는 상황을 생각해보자.

        // 생성자 호출
        // 클래스라는 것 자체가 커스텀 데이터 타입이기때문에
        // 데이터 타입 적는곳에 class 이름이 작성됨
        final Led led = new Led();

        System.out.println("현재 전구 상태 : " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
        led.setTurnOn(true);
        System.out.println("현재 전구 상태 : " + (led.getTurnOn() ? "켜짐" : "꺼짐"));
    }
}
