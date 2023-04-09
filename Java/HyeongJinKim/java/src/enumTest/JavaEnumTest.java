package enumTest;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV;

        System.out.println(testPattern);
        System.out.println(testPattern.getValue());

        for (Pattern pattern: Pattern.values()) {
            System.out.println("pattern name: " + pattern + ", value: " + pattern.getValue());
        }
    }
}

// Pattern testPattern = Pattern.TUV;
// -> Pattern에 직접 접근한다.
// -> testPattern에 TUV를 가져온다.

// Pattern.values();
// -> ABCD("첫 번째 패턴", 1) 에서 ABCD를 받아옴

// Pattern.getValue();
// -> getter 매서드 이름이다. 1을 받아옴
