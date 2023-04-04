package workSpace;


class Price {
    final private int MIN = 5000;
    final private int MAX = 10000;

    final private int price;
    public Price () {
        this.price = (int) (Math.random() * MAX - MIN + 1) +MIN;
    }

    public int getPriceRandom() {
        return price;
    }
}


class AppleNum {
    final private int MIN = 3;
    final private int MAX = 5;
    final private int appleNum;

    public AppleNum() {
        this.appleNum = (int) (Math.random() * MAX - MIN + 1) +MIN;
    }
    public int getAppleNum() {
        return appleNum;
    }
}

public class Apple {

    final private AppleNum appleNum = new AppleNum();
    final private Price [] price = new Price[appleNum.getAppleNum()];
    int applePriceSum = ApplePriceSum();

    public Apple () {
        System.out.println("총 합계는 " + applePriceSum + "원 입니다. ");
    }

    private int ApplePriceSum() {
        int sum = 0;

        for (int i = 0; i < appleNum.getAppleNum(); i++ ) {
            price[i] = new Price();
            sum += price[i].getPriceRandom();
        }
        System.out.println(sum);
        return sum;

    }


    public static void main(String[] args) {
        Apple apple = new Apple();

    }

}
