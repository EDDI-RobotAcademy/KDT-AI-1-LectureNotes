package test.test04;



public class Apple {
    public static void main(String[] args) {
        int MIN = 5000;
        int MAX = 10000;
        AppleTest appleTest = new AppleTest(MIN,MAX);

        appleTest.RandomAppleCost();
        int total = appleTest.calculateCost();
        System.out.println(total);
    }



}
