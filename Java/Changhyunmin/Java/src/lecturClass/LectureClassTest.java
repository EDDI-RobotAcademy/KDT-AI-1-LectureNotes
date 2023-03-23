package lecturClass;
// Led 클래스는 불이 켜졌다 혹은 꺼졌다만 관리하면 됩니다.
// 클래스의 형태는 현재 아래와 같습니다.
/*
    ------ Led 객체 ------
    |      isTurnOn     |
    ---------------------
    |     Led 생성자     |   <<<- new를 하면 이와 같은 형태가 만들어지는 것입니다.
    |     getTurnOn     |
    |     setTurnOn     |
    ---------------------
 */
class Led{
    private boolean isTurnOn;
    // 생성자는 class의 이름과 같습니다.
    // 그리고 아래와 같이 리턴 타입이 없습니다.
    // 만드는 규칙이라면 아래와 같습니다.
    // 1. public을 적고 클래스 이름을 적은 이후 소괄호()를 작성후 중괄호{}를 작성합니다.
    // 2. 만약에 외부에서 값을 입력 받을 것이라면 소괄호에 입력받을 형태를 작성합니다.
    // 3. 실제 클래스가 new를 통해 객체화 될 때 구동시키고 싶은 작업을
    //    중괄호 내부에 배치합니다.
    //    즉 현재는 new를 통해 만들어질 때
    //    기본값으로 전구를 꺼놓은 상태로 시작하게 됩니다.
    public Led() {
        this.isTurnOn = false;
        System.out.println("생성자 호출");
    }


    public boolean isTurnOn() {
        return isTurnOn;
    }

    // 사실은 지가 지를 킬 수 없기 때문에 다른 객체의 도움을 받아야함
    // 사실 수십년간의 SW 전문가들이 이러한 개념들을 정리하였고
    // 그 개념의 일환으로 탄생하게 된 개념이 Domain Service 개념입니다.
    // Domain Service를 만들어서 얻는 이점은
    // 비즈니스 관점을 좀 더 명확하게 만들어준다는 이점이 있습니다.
    // 실제로 전구를 키고 끄는 작업을 가지고 비즈니스를 할만한 것들이 많지는 않지만
    // 그래도 Domain Service를 나눠 본다면 아래와 같은 것들이 존재할 것입니다.
    // 키기, 끄기, 깜빡이기

    // -> 조금 쉽게 접근해 보자면 Domain Service는
    // 객체 스스로가 직접 하기에는 표현이 애매해지는 작업들을
    // 모두 Domain Service로 재배치하게 됩니다.
    // 이를 통해 가독성과 유지보수성의 향상을 가져올 수 있습니다.

    // 제어하는 Controller에 RequestForm 객체를 전달
    // RequestForm 객체는 Domain Service에서 처리하기 적합한 형태인 Request로 변환
    // 그리고 Request를 보고 적절한 Entity를 추출하게 되는데
    // 이런 관점으로 접근하면 setter를 완벽하게 제거 할 수 있습니다.
    // 즉 필요하면 final 객체에 final 변수들을 설정해서 전달한다는 의미입니다.

    // * 입력 관점에서 살펴봅시다!
    //        3 -> [     ] -> 9      (입력 타입 int)
    // 버튼 누름 -> [     ] -> true   (입력 타입 Button class)
    //        1 -> [     ] -> "예금" (입력 타입 int)
    //             [     ] -> 20     (입력 타입 void)
    //   참/거짓 -> [     ]           (입력 타입 boolean)
    public void  isTurnOn(boolean turnOn){
        isTurnOn = turnOn;
    }

}

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

        // 전구(LED)를 키는 상황을 생각해봅시다.
        //새성자 호출하는 부분
        System.out.println("생성자 호출전");

        //왜 데이터 타입을 적는곳에 class 이름이 오는 것이지?
        //A: 클래스라는 것 자체가 커스텀 데이터 타입이기 때문입니다.
        //  여러분들이 직접 커스텀 할 수 있는 데이터 타입이 클래스라 보면 됩니다.
        final Led led = new Led(); //       <-초기 생성 (꺼짐 - isTurnOn:fales)
        System.out.println("생성자 호출후");


        System.out.println("현재 전구 상태: " + (led.isTurnOn()? "켜짐" : "꺼짐"));
        led.isTurnOn(true);//               <-초기 생성 (꺼짐 - isTurnOn:true)
        System.out.println("현재 전구 상태: " + (led.isTurnOn()? "켜짐" : "꺼짐"));
    }
}
