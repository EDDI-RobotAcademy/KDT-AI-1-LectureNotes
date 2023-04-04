package practice.basic;

import utility.random.CustomRandom;

public class Basic {
    public Basic () {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}

class Basic3 {
    public Basic3 () {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            } else {
                continue;
            }
        }
    }
}

class Basic4 {
    private int sum = 0;
    public Basic4 () {
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                this.sum += i;
            } else {
                continue;
            }
        }
    }

    @Override
    public String toString() {
        return "Basic4{" +
                "sum=" + sum +
                '}';
    }
}
class Apple {
    final int applePrice;
    final int applePiece;
    final int appleSum;
    public Apple () {
        this.applePrice = 1000 * (CustomRandom.generateNumber(5, 10));
        this.applePiece = CustomRandom.generateNumber(3, 5);
        this.appleSum = applePiece * applePrice;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "applePrice=" + applePrice +
                ", applePiece=" + applePiece +
                ", appleSum=" + appleSum +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(new Apple());
    }
}

