package practice.apple.AppleReview;
// 4. 사과의 가격을 5000 ~ 10000 사이의 랜덤값을 가지게 만듭니다.
// 5. 수확을 할 때 얻는 사과는 3 ~ 5개를 얻게 만듭니다.
// 6. 수확하여 얻은 사과의 전체 가격을 산출해봅시다.
public class RandomAppleCostTest {
    public static void main(String[] args) {
        final int APPLE_COST_MIN = 5000;
        final int APPLE_COST_MAX = 10000;
        // 그리고 아래 생성자에 들어갈 매개변수들을 선언해줌

        RandomApple randomApple = new RandomApple(APPLE_COST_MIN, APPLE_COST_MAX);
        // 아마 이걸 가장 먼저 하지 않았을까 싶음
        // 그리고 RandomApple 클래스로 넘어가서 생성자를 만들어줬을 듯

        randomApple.acquireApples(); // acquireApples 메서드 부름

        final int totalAppleCost = randomApple.caculateCost();
        // 사과의 총 가격이라는 변수에 계산한 메서드를 저장

        System.out.println("전체 사과의 가격: " + totalAppleCost);

    }
}
