package staticTest;

public class WhyStatic {
    public static void main(String[] args) {
        System.out.println("왜 main()은 new WhyStatic()을 안 했는데도 동작하지?");

        // static이 붙어있는 경우엔 어떻게 되었는가?
        // 전역 처리가 되었음
        // 우리가 구동하는 프로그램 어디에서든지 사용할 수 있음을 의미합니다.
        // 결론적으로 이것이 되려면 상시 메모리에 객체 상태로 존재해야함을 의미합니다.
        // 이것을 서포트하는 키워드가 static 입니다.

        // 모든 프로그램의 시작 위치는 main()입니다.
        // 그러므로 main은 항시 메모리에 상주할 필요가 있습니다.
        // 우리가 사용하는 모든 데이터는 메모리에 올라가야 눈으로 확인이 가능합니다.

        // 결론: static이 붙으면 메모리에 상주합니다.
    }
}
