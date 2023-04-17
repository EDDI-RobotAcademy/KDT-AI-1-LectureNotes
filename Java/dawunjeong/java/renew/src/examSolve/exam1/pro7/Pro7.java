package examSolve.exam1.pro7;

import examSolve.exam1.customLibrary.utility.randomNumber.CustomRandomNumber;

// 문제 7번
// 사과 초기 가격이 2000원
// 인상률은 3~20%일 때 인상된 사과의 가격
public class Pro7 {
    public static void main(String[] args) {
        final int appleCost = 2000;

        // 3에서 20 중 랜덤한 숫자를 뽑아내서 100으로 나누기
        // 소수점까지 나와야 하므로 f를 붙여서 float으로 표현
        final float increaseRate = CustomRandomNumber.generateRandomNumber(3,20) / 100.0f;
        System.out.println("인상률: " + increaseRate);

        // 인상 가격: 기존 가격 * (1 + 인상률)
        System.out.println("인상 후 사과 가격: " + appleCost * (1 + increaseRate));
    }
}
