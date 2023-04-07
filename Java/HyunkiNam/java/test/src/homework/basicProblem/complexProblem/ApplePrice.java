package homework.basicProblem.complexProblem;

public class ApplePrice {
    final int MIN = 500;
    final int MAX = 1000;
    final int applePrice;

    public ApplePrice(){
        this.applePrice = ((int)(Math.random() * (MAX-MIN+1)) + MIN) * 10;
    }

    public int getApplePrice() {
        return applePrice;
    }
}