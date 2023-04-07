package homework.basicProblem.complexProblem;

public class AppleTotalPrice {
    public static void main(String[] args) {
        ApplePrice ApplePrice = new ApplePrice();
        AppleCount AppleCount = new AppleCount();

        int applePrice = ApplePrice.getApplePrice();
        int appleCount = AppleCount.getAppleCount();

        System.out.println("사과 가격 : " + applePrice +
                " 수확한 사과 갯수 : " + appleCount +
                " 전체 가격 : " + applePrice * appleCount);
    }
}
