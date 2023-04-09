package basicProblem.classBasicProblem;

public class AppleSale {
    public int applePrice() throws InterruptedException {
        final int applePriceMin = 5000;
        final int applePriceMax = 10000;

        System.out.println("------------------------------------------------------------------------------");
        System.out.print("사과 불러오는 중.....");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print("🍎");
            Thread.sleep(500);
        }
        int applePrice = (int) ((Math.random() * (applePriceMax - applePriceMin + 1)) + applePriceMin);

        System.out.println();

        System.out.println("사과 가격은 " + applePrice + " 원으로 책정 되었습니다.");

        return applePrice;

    }

    public int appleNumber() throws InterruptedException {

        final int appleNumberMax = 5;
        final int appleNumberMin = 3;

        System.out.println("------------------------------------------------------------------------------");
        System.out.print("사과 재고 확인 중.....");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print("🍎");
            Thread.sleep(500);
        }

        int appleNumber = (int) ((Math.random() * (appleNumberMax - appleNumberMin + 1)) + appleNumberMin);
        System.out.println();
        System.out.println("사과 개수는 " + appleNumber + " 개가 확인되었습니다.");

        return appleNumber;
    }


    public void appleTotalPrice(int applePrice, int appleNumber) throws InterruptedException {

        int appleTotalPrice = appleNumber * applePrice;

        System.out.println("------------------------------------------------------------------------------");
        System.out.print("사과 총 가격 계산 중 ...");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(500);
            System.out.print("🍎");
            Thread.sleep(500);
        }

        System.out.println();
        System.out.println("총 가격은 ' " + appleTotalPrice + " ' 원 입니다. ");

    }
}
