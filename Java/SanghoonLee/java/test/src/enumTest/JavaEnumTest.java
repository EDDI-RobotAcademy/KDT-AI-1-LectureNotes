package enumTest;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV;

        System.out.println(testPattern);
        System.out.println(testPattern.getValue());

        for (Pattern pattern: Pattern.values()) {
            System.out.println("pattern: " + pattern +
                    ", name: " + pattern.getName() +
                    ", value: " + pattern.getValue());
        }

        testPattern = Pattern.HIJK;
        final Pattern comparePattern = Pattern.HIJK;
        final Pattern wrongPattern = Pattern.EFG;

        // 아래와 같이 enum을 사용하면 패턴 매칭을 할 수도 있습니다.
        // 같으면 0 다르면 0이 아닌 숫자가 나오게 됩니다.
        System.out.println(testPattern.compareTo(comparePattern));
        System.out.println(testPattern.compareTo(wrongPattern));
    }
}
