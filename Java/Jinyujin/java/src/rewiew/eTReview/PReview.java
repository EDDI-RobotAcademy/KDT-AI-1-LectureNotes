package rewiew.eTReview;

public enum PReview {
    // class를 enum으로 바꿔줘야 함!
    ABCD("첫 번째 패턴", 1),
    EFG("두 번째 패턴", 2),
    HIJK("세 번째 패턴", 3),
    LMNOP("네 번째 패턴", 4),
    QRS("다섯 번째 패턴", 5),
    TUV("여섯 번째 패턴", 6),
    WXYZ("일곱 번째 패턴", 7); // 여기 마지막에만 ;

    // 패턴은 마음대로 지정 가능
    // 문자열이던 숫자던 상관 없음
    // 지정해주고 각각에 대해 표현하고 싶은 것 지정

    final private String name;
    final private int value;

    PReview(String name, int value) {
        this.name = name;
        this.value = value;
    }
    // 선생님은 getter를 사용하셨는데 일단 난 getter를 사용하지 말고 JETReview 클래스로 넘어가보자

    // JETReview 클래스에서 value값을 프린트하기 위해 getter 생성
    public int getValue() {
        return value;
    }

//    @Override
//    public String toString() {
//        return "PReview{" +
//                "name='" + name + '\'' +
//                ", value=" + value +
//                '}';
//    }
}
