package homework.testBank.test;

import utility.random.CustomRandom;
import java.util.ArrayList;

class Apple{
    private int appleNum;
    private int appleAmount;

    // 사과의 개수가 나온 만큼 각 사과의 가격을 넣어준다.
    ArrayList<Integer> appleTotalPrice;

    public Apple() {
        appleTotalPrice = new ArrayList<>();
    }

    public int appleNumSave(){
        final int APPLE_MIN_NUM = 3;
        final int APPLE_MAX_NUM = 5;

        this.appleNum = CustomRandom.generateNumber(APPLE_MIN_NUM, APPLE_MAX_NUM);
        System.out.printf("수확한 사과의 개수: %d\n", appleNum);

        return this.appleNum;
    }

    public void applePriceSave(int appleSaveNum){
        final int APPLE_MIN_PRICE = 5000;
        final int APPLE_MAX_PRICE = 10000;

        for(int i = 0; i < appleSaveNum; i++){
            int randomApplePrice = CustomRandom.generateNumber(APPLE_MIN_PRICE, APPLE_MAX_PRICE);
            appleTotalPrice.add(randomApplePrice);

            System.out.printf("사과 가격: %d\n", appleTotalPrice.get(i));
        }
    }

    public void appleAmountSave(){
        for(int i = 0; i < appleTotalPrice.size(); i++){
            this.appleAmount = appleTotalPrice.get(i) * appleNum;
        }
        System.out.printf("수확한 사과의 전체 가격: %d\n", appleAmount);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "appleNum=" + appleNum +
                ", appleAmount=" + appleAmount +
                ", appleTotalPrice=" + appleTotalPrice +
                '}';
    }
}

public class complexTest {
    public static void main(String[] args) {
        Apple apple = new Apple();

        // 수확한 사과의 개수를 받아서 넘겨준다.
        int appleSaveNum = apple.appleNumSave();

        // 수확한 사과의 양 만큼 각각의 가격을 구한다.
        apple.applePriceSave(appleSaveNum);

        // 각각의 가격과 사과 개수를 곱하여 전체 가격을 구한다.
        apple.appleAmountSave();

        System.out.println(apple);
    }
}
