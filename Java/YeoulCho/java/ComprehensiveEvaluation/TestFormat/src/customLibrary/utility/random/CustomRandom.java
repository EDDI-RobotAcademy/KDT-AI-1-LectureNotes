package customLibrary.utility.random;

public class CustomRandom {

    final private static int MIN = 0;
    // static은 언제나 메모리에 상주함(stack도 Heap도 아님)
    // 그러므로 별도로 new를 할 필요없이 사용할 수 있음
    // 대표적으로 main, Math.random 같은 녀석들

    public static int generateNumber ( int min, int max) {
        return (int)(Math.random() * (max - min +1)) +min;
    }

    //max 값 하나만 적었을때도 작동되게
    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }

}