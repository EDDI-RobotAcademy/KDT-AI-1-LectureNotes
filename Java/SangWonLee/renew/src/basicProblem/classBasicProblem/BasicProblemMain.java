package basicProblem.classBasicProblem;

public class BasicProblemMain {

    public static void main(String[] args) throws InterruptedException {

        final int evenNumber = 2;
        final int thirdNumber = 3;
        final int fourthNumber = 4;

        OneHundredMultiple oneHundredMultiple = new OneHundredMultiple();

        System.out.println("⭐️ 짝수만 출력하기 ⭐");
        oneHundredMultiple.multiple(evenNumber);

        System.out.println();

        System.out.println("⭐️ 3의 배수만 출력하기 ⭐");
        oneHundredMultiple.multiple(thirdNumber);

        System.out.println();

        System.out.println("⭐️ 4의 배수 합 출력하기 ⭐");
        oneHundredMultiple.multipleSum(fourthNumber);

        AppleSale appleSale = new AppleSale();

        appleSale.appleTotalPrice(appleSale.applePrice(),appleSale.appleNumber());






    }
}
