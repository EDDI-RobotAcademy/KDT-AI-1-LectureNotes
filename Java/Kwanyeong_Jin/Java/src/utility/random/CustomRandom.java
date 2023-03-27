package utility.random;

public class CustomRandom {

    final private static int MIN =0;
    // static은 언제나 메모리에 상주(stack, Heap아님)
    // 그러므로 별도로 new를 할 필요없이 사용할 수 있음
    // 대표적으로 main, Math.random같은 것들

    public static int generateNumber (int min, int max){
        return (int)(Math.random() * (max - min +1)) + min;
    }

    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }
}
