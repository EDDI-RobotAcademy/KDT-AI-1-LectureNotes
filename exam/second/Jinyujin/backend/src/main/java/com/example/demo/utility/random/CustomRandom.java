package com.example.demo.utility.random;

public class CustomRandom {

    // static은 언제나 메모리에 상주함(Stack도 Heap도 아님)
    // 그러므로 별도로 new를 할 필요 없이 사용할 수 있음
    // 대표적으로 main, Math.random같은 녀석들
    public static int generateNumber (int min, int max) {
        return (int)(Math.random() * (max - min +1)) +min;
    }
    //... 이렇게 해두면 불러서 편하게 꺼내쓸 수 잇음

    final private static int MIN = 0; //... min을 무조건 0으로 두고 시작하는 경우
    // max 값만 지정하고 싶을 때

    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }
}
