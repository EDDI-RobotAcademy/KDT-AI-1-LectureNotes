package Enum;

public class JavaEnumTest {

    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV; // Patten 클래스에 TUV를 가져옴.

        System.out.println(testPattern); // TUV
        System.out.println(testPattern.getValue()); // 6

        for (Pattern pattern: Pattern.values()){ // foreach문으로 전체 enum을 가져옴
            System.out.println("pattern: " + pattern +
                    ", name: " + pattern.getName() + // 이름을 가져옴
                    ", value: " + pattern.getValue()); // 값을 가져옴
        }
//        pattern: ABCD, name: 첫 번째 패턴, value: 1
//        pattern: EFG, name: 두 번째 패턴, value: 2
//        pattern: HIJK, name: 세 번째 패턴, value: 3
//        pattern: LMNOP, name: 네 번째 패턴, value: 4
//        pattern: QRS, name: 다섯 번째 패턴, value: 5
//        pattern: TUV, name: 여섯 번째 패턴, value: 6
//        pattern: WXYZ, name: 일곱 번째 패턴, value: 7

        testPattern = Pattern.HIJK; // testPattern을 HIJK로 설정
        final Pattern comparePattern = Pattern.HIJK; // 같은 값의 비교
        final Pattern wrongPattern = Pattern.EFG; // 다른 값의 비교

        // 아래와 같이 enum을 사용하면 패턴 매칭을 할 수도 있습니다.
        // 같으면 0 다르면 0이 아닌 숫자가 나오게 됩니다.
        System.out.println(testPattern.compareTo(comparePattern)); // 0
        System.out.println(testPattern.compareTo(wrongPattern)); // 1
    }

}
