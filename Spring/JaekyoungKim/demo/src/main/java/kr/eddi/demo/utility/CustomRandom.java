package kr.eddi.demo.utility;

public class CustomRandom {
    final private static int Min =0;
    // static은 언제나 메모리에 사웆함(스택도 힙도 아님)
    // 그러므로 별도로 new 를 할 필요가 없이 사용 할 수있음
    // 대표적으로 main, Math.random. 같은 녀석들

    public static int generateNumber (int min, int max){
        return (int) (Math.random()*(max-min)+1)+min;
    }
    public static int generateNumber(int max){
        return generateNumber(Min,max);
    }
}
