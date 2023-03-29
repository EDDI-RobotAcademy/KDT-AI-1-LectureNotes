package enumTest;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV;

        System.out.println(testPattern);
        System.out.println(testPattern.getValue());

        for (Pattern pattern: Pattern.values()) {
            System.out.println("pattern name: " + pattern + ", value: " + pattern.getValue());
        }

        for (Pattern2 pattern2 : Pattern2.values()){
            System.out.println(pattern2 + "\n"+ pattern2.getName() + "\n"+pattern2.getValue() + "\n"+pattern2.getValue2());
        }
    }
}