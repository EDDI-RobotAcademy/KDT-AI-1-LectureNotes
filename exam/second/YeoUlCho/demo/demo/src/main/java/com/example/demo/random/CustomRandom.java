package com.example.demo.random;

public class CustomRandom {

    final private static int MIN = 0;

    public static int generateNumber ( int min, int max) {
        return (int)(Math.random() * (max - min +1)) +min;
    }

    //max 값 하나만 적었을때도 작동되게
    public static int generateNumber (int max) {
        return generateNumber(MIN, max);
    }

}

