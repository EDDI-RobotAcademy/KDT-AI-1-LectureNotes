package rewiew.cardPatternReview;

public enum CPatternReview { // class를 enum으로 바꿔주어야 함
                             // 그래야 얘가 패턴으로 인식함
    PATTERN_A("A", 1),
    PATTERN_2("2", 2),
    PATTERN_3("3", 3),
    PATTERN_4("4", 4),
    PATTERN_5("5", 5),
    PATTERN_6("6", 6),
    PATTERN_7("7", 7),
    PATTERN_8("8", 8),
    PATTERN_9("9", 9),
    PATTERN_J("J", 10),
    PATTERN_Q("Q", 11),
    PATTERN_K("K", 12);

    // 이 패턴에 대해 어떤 변수가 들어갔는지 선언
    final private String name;
    final private int value;
    public static CPatternReview[] patterns = CPatternReview.values(); // public static을 붙여주니 오류 해결 - 왜?
    // 클래스 내부에 배치되어 있는 CardPattern 배열은 모든 패턴을 배열화시켜 저장하는 작업
    // 앞에 static 키워드가 붙어 있으므로 이전에 CustomRandom을 만들었던 랜덤 유틸리티와 목적이 동일
    // 언제나 패턴에서 뽑아서 쓸 수 있게 만들기 위함

    CPatternReview(String name, int value) {
        this.name = name;
        this.value = value;
    } // 생성자까지 만들어주니 패턴에서 오류 없어짐

    public static CPatternReview checkPatternByIndex(int index) { // 인덱스 값 가지게 되면
                                                                  // 특정 패턴 리턴하도록 하는 메소드 생성
        return patterns[index]; // patterns가 계속 인식되지 못하는 오류 발생
        // getter를 만들어보자 -> 노상관
        // 위에 public static 을 붙여주니 오류해결
        // 위의 public static CPatternReview[] patterns = CPatternReview.values();
        // 이 코드를 통해 이미 배열에 박혀있으니 이 배열에 박힌 값을 index 따라 뽑아내는 작업

        // static이 도대체 뭐길래?
        // static: 클래스 변수나 클래스 메서드를 선언할 때 사용
        // 여기서 public static CPatternReview[] patterns = CPatternReview.values(); 코드에
        // static이 붙어 있는 이유는 enum 자체에 checkPatternByIndex() 매서드를 유틸리티 매서드로 만들었기 때문

        // static이 붙으면 언제나 메모리로 상주한다고 했음 (Stack도 Heap도 아닌)
        // static이 붙으면 전역으로 걸린다 == 나도, 다른 사람도, 다른 나라에 사는 사람도 모두 알게 된다는 뜻

        // static이 붙은 메서드가 유틸리티 매서드
        // 이런 정보들을 관리하는 클래스를 유틸리티 매서드라 볼 수 있습니다.
        // 가장 대표적인 녀석은 Math 이며
        // Math.random() 또한 static으로 만들어진 유틸리티 매서드입니다.
        // 파이값과 같은 값도 static으로 걸리는데
        // 불변의 진리에 해당하는 것은 전역으로 걸어도 되기 때문
    }

    // 더 상세하게 보기 위해 여기에도 toString() 처리
    // 여기서는 각각 카드 패턴에 대한 이름과 밸류값 출력

    @Override
    public String toString() {
        return "CPatternReview{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
