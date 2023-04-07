package homework.basic;

import utilityRandom.CustomRandom;

class Apple{
    final int price= CustomRandom.generateNumber(5000,10000);
    //generateNumber (int min, int max){
    //        return (int) (Math.random()*(max-min)+1)+min;
    //    }
    final int appleYield=CustomRandom.generateNumber(3,5);

    final int sales=price*appleYield;

    public Apple() {

    }
}

public class basic4 {
    public static void main(String[] args) {
        Apple apple =new Apple();
        System.out.println("이번 사과의 가격은 "+apple.price+"원 입니다.");
        System.out.println("이번 사과의 수확량은 "+apple.appleYield+"개 입니다.");
        System.out.println("사과의 총 매출액은 "+apple.sales+"원 입니다.");

    }
}
