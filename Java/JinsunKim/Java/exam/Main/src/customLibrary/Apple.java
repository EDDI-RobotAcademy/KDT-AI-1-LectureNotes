package customLibrary;

public class Apple  {
    int applePrice = 2000;

    public Apple() {
        double price = appleRandomPrice();
    }

    public int appleRandomPrice() {
        double priceUpMin = 0.2;
        double priceUpMax = 0.3;


        double randomPrice = (Math.random() * priceUpMax - priceUpMin + 1) +priceUpMin;
        int price = (int) (randomPrice * applePrice);
        System.out.println("변동된 사과가격: " + price + "원");
        return price;
    }

}