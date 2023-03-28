package enumTest;

public class JavaEnumTest {
    public static void main(String[] args) {
        Pattern testPattern = Pattern.TUV;

        System.out.println(testPattern);
        System.out.println(testPattern.getValue());

//        일반적으로 배열을 탐색할 때 다음과 같이 for 반복문을 사용합니다.
//
//        int[] arr = {0, 1, 2, 3, 4};
//        for (int i = 0; i < 5; i++) {
//          System.out.println(arr[i]); // 0 1 2 3 4 출력
//        }
//
//        위 반복문을 foreach 반복문으로 다음과 같이 표현할 수 있습니다.
//
//        int[] arr = {0, 1, 2, 3, 4};
//        for (int i : arr) {
//            System.out.println(arr[i]); // 0 1 2 3 4 출력
//        }
        for (Pattern pattern: Pattern.values()) {
            System.out.println("pattern name: " + pattern + ", value: " + pattern.getValue());
        }
    }
}