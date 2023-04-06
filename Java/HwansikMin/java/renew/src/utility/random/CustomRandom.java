package utility.random;

public class CustomRandom {


    // static은 언제나 메모리에 상주함 (Stack도 Heap도 아님)
    // 그러므로 별도로 new를 할 필요 없이 사용할 수 있음
    // 대표적으로 main, Math.random 같은 녀석들
    public static int generateNumber (int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // 입력하는 변수의 갯수가 한개라면 그 값이 최댓값으로 설정이 되고
    // 최솟값은 자동으로 0이 설정되서 위에 있는 변수 두개짜리 함수를 작동시키는 함수
    final private static int MIN = 0;
    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }
}
