package practice.apple;

import java.util.ArrayList;
import java.util.List;

// 수확하여 얻은 사과의 전체 가격을 산출
public class TotalApple {
    // 사과를 수확한 만큼 가격을 랜덤으로 뽑고 그 합을 구함
    private GetApple getApple = new GetApple();
    private List<ApplePrice> applePriceList = new ArrayList<>();
    private int totalAppleSum = 0;

    public TotalApple() {
        // 수확하여 얻은 사과의 전체 가격을 산출
        // 사과를 수확한 만큼 가격을 랜덤으로 뽑고 그 합을 구함
        for (int appleIdx = 0; appleIdx <= getApple.getGetApple() - 1; appleIdx++) {
            ApplePrice applePrice = new ApplePrice();
            applePriceList.add(applePrice);
            totalAppleSum += applePrice.getApplePrice();
        }
    }

    @Override
    public String toString() {
        return "TotalApple{" +
                getApple + '\n' +
                ", applePriceList=" + applePriceList + '\n' +
                ", totalAppleSum=" + totalAppleSum +
                '}' ;
    }
}
