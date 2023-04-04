package practice.practice5;

public class TotalApple {

    private int totalPrice;
    ApplePrice price = new ApplePrice();
    GetApple get = new GetApple();

    // 가격에서 랜덤값 하나 * 수확에서 랜덤값 하나
    public TotalApple() {

        // 새로 정의하는게 아니라 이미 만들어놓은 클래스에서 가져오게
        // 지금은 한번 더 정의한 것
        totalPrice = price.getApplePrice() * get.getGetApple();
    }

    @Override
    public String toString() {
        return "TotalApple{" +
                "price=" + price +
                ", get=" + get +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
