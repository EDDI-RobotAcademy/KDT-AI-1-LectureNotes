package problems.prob8;
//final 키워드를 사용하는 이유에 대해 기술
public class Problem8 {
    public static void main(String[] args) {
        // final을 변수나 클래스에 붙이면 처음에 정의한 상태가 변하지 않는다.
        // 자바 내에 변수들은 보통 가변적이기 때문에, final을 붙여서 참조값을 변경하지 못하게 만든다.
        // final이 붙은 변수는 초기화 후 변경이 불가하다.
        // final로 선언된 인자는 메서드 내 변경이 불가능하다.
        // final을 클래스에 붙이면 다른 클래스에서 상속이 불가능하다.
        // final을 메서드에 붙이면 override를 제한하게 된다.
        // 즉, final은 절대 변경하면 안되는 객체에 사용하기에 좋다.
        // 디버깅하기에도 좋으며, 변경되는 변수만 추적하도록 만들어 로직 파악에 용이하다.
    }
}
