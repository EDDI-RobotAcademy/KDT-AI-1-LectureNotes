package rewiew.cardPatternReview;

public class CardReview {
    // 여기서 패턴을 정리해서 이넘리스트테스트 클래스에서 써먹을 수 있도록

    final private CPatternReview cardPattern;

    public CardReview(CPatternReview cardPattern) {
        this.cardPattern = cardPattern; // 카드 패턴이라는 enum을 입력받고 있는 것
    }

    // toString()을 통해 각각의 패턴 정보 확인
    // 더 상세하게 보려면 카드패턴에다가 투스트링 추가

    @Override
    public String toString() {
        return "CardReview{" +
                "cardPattern=" + cardPattern +
                '}' + '\n'; // toString()에 '\n' 줄바꿈 문자 사용 방법
    }
}
