package com.example.demo.utility;

public class RegistNumber {

    static int START = 0;
    static int MIN = 0;
    static int MAX = 9;
    static int digit = 10;

    public static long getRegistNumber(){

        String transformRegistNumber = "";

        for(int i = START; i < digit ;i++){
            int randomNumber = CustomRandom.generateNumber(MIN,MAX);
            String randomNumberStr = String.valueOf(randomNumber);
            transformRegistNumber += randomNumberStr;
        }

        long resultRegistNumber = Long.parseLong(transformRegistNumber);

        return resultRegistNumber;
    }

}
