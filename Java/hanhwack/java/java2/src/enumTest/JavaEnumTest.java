package enumTest;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV;

        System.out.println(testPattern);  //TUV
        System.out.println(testPattern.getValue()); //6

        for(Pattern pattern: Pattern.values()) {
            System.out.println("pattern name: " + pattern + ", vlaue: " +pattern.getValue());
        }
    }
}
