package enumTest;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV;
        System.out.println(testPattern);
        System.out.println(testPattern.getValue());


        //.value() -> enum의 정보를 보여라?
        for (Pattern pattern : Pattern.values()) {
            System.out.println("pattern" + pattern + ", name: " + pattern.getName()
                    + ", value" + pattern.getValue());
        }

    }
}
