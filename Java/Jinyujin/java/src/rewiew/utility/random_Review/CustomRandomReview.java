package rewiew.utility.random_Review;

// Custom random 이란? 개발자가 직접 정의한 난수 생성기
// (int) (Math.random() * MAX + MIN) 을 어디서든 쓸 수 있는 유틸리티로 만들어버리기

public class CustomRandomReview {
    // max랑 min이 나올 때마다 써주기 귀찮으니 그냥 여기다 만들어두고 나중에 가져다 쓸 수 있는 용도
    // static은 언제나 메모리에 상주하기 때문에 필요할 때마다 불러서 쓸 수 있다
    // stack도 아니고 heap도 아니라고 함
    // 그래서 new를 써주지 않아도 된다
    // 대표적으로 main, Math.random 같은 녀석들

    final private static int MIN = 0;

    public static int generateNumber(int min, int max) {return (int) (Math.random() * max - min +1) + min;}
    // 이렇게 해두면 나중에 편하게 불러서 쓸 수 있다

    // 예시)   int[] diceNumberArray3 = new int[MAX_DICE_NUM2];
    //        for (int i =0; i < diceNumberArray3.length; i++) {
    //            diceNumberArray3[i] = CustomRandom.generateNumber(MIN, MAX); //... 이렇게 만들어두면 굳이 주사위가 아니더라도 min, max값이 필요할 때 얘를 부르면 됨
    //            diceSum += diceNumberArray3[i];
    //        }

    // MIN은 0으로 지정하고 max값만 지정하고 싶은 경우
    public static int generateNumber (int max) {return generateNumber(MIN, max);}
}
