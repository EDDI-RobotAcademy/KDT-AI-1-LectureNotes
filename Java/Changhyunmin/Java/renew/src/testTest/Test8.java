package testTest;

class FruitSeller{
    int numOfApple = 100;
    int myMoney = 0;
    final int ApplePrice = 1000;

    public int saleApple(int money) {
        int num = money / ApplePrice;
        numOfApple -= num;
        myMoney += money;
        return num;
    }
    public void showSaleResult(){
        System.out.println("[판매자] 남은 사과 개수 : " + numOfApple);
        System.out.println("[판매자] 판매수익 : " + myMoney);
    }
}
class FruitBuyer{
    int myMoney = 5000;
    int numOfApple = 0;
    public void buyApple(FruitSeller seller, int Money){
        numOfApple += seller.saleApple(Money);
        myMoney -= Money;
    }
    public void showBuyResult(){
        System.out.println("[구매자] 현재잔액 : " + myMoney);
        System.out.println("[구매자] 사과갯수 : " + numOfApple);
    }
}
public class Test8 {
    public static void main(String[] args) {
        FruitSeller seller = new FruitSeller();
        FruitBuyer buyer = new FruitBuyer();

        System.out.println("구매행위가 일어나기 전의 상태");
        seller.showSaleResult();
        buyer.showBuyResult();

        System.out.println("구매행위가 일어난 후의 상태");
        buyer.buyApple(seller,5000);
        seller.showSaleResult();
        buyer.showBuyResult();
    }

}
