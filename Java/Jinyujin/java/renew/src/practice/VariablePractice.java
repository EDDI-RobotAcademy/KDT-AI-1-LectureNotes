package practice;

public class VariablePractice {
    // 여기에 선언해주는 애들이 인트턴스변수
    final private int number;

    public VariablePractice(int age) {
        this.number = age; // 생성자에서 초기화
    }
    // 그럼 final 선어해주고 생성자 만들어 주는 이유도 다른 클래스에서 저걸 사용하기 위해서?

    public void whatName() {
        // 메서드 안에서 선언해주는 애들이 지역 변수
        final int name;
    }
}
