package basic.basic4;

public class AppleBuy {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Price price = new Price();
        int HarvestApple = apple.Harvest();
        int CurrentPrice = price.applePrice();
        int CurrentPrice1 = price.applePrice1();

        System.out.println(HarvestApple);
        System.out.println(CurrentPrice);
        System.out.println(CurrentPrice1);
        System.out.println(HarvestApple*CurrentPrice);

    }
}
