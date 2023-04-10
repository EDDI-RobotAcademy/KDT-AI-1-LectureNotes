package customLibrary.prob7;

public class AppleShop {
    // 사과를 한 개에 2000원씩 판다.
    private int appleCost = 2000;

    // 랜덤적인 가격 변동 발생 (인상률: 3(60원) ~ 20%(400원))
    public AppleShop() {
        int AddLowCost = (int)(appleCost * 0.03);
        int AddHighCost = (int)(appleCost * 0.2);

        int randomUpCost = (int)(Math.random() * AddHighCost) + AddLowCost;
        this.appleCost += randomUpCost;
    }

    @Override
    public String toString() {
        return "" + appleCost;
    }
}
