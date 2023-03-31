package enumTest;

import java.util.regex.PatternSyntaxException;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.A;
        System.out.println(pattern);
        System.out.println(pattern.getValue());

        for (Pattern pattern1: Pattern.values()){
            System.out.println("pattern: "+pattern+", name: "+pattern1.getName()+", value: "+pattern1.getValue());
        }
        pattern =Pattern.A;
        final Pattern comparePattern =Pattern.A;
        final Pattern worngPattern=Pattern.A;
        System.out.println(pattern.compareTo(worngPattern));
        System.out.println(pattern.compareTo(comparePattern));
    }
}
