package rewiew.cardPatternReview;

import java.util.ArrayList;
import java.util.List;

public class ELTestReview {
    // 목적: 포커 카드(숫자만) 패턴 enum을 이용하여 노가다 줄이기

    public static void main(String[] args) {

        List<CardReview> CardList = new ArrayList<>();
        // 그럼 이제 변수 CardList를 이용해야 겠지?
        // 카드패턴이랑 카드 클래스에서 투스트링 만들어놓은 것 활용도 해야함
        // 카드를 리스트에서 하나씩 뽑아내기 위해서 for문 작성

        final int MAX_CARD_NUMBER = 12;

//        for (int i = 0; i < MAX_CARD_NUMBER; i++) {
//            CardList.add(new CardReview(CPatternReview.checkPatternByIndex(i))); // 이거 만들어주기
                                                                                   // 여기서부터 어려움
                                                                                   // 아래 주석 안해놓은 코드가 더 좋은 코드라고 하니 그것으로 공부하자

//            public CardReview(CPatternReview cardPattern) {
//                this.cardPattern = cardPattern;
//            }
            // 위 코드는 카드 패턴이라는 enum을 입력받고 있는 상태
            // 카드 객체를 만들 것이라면 new Card()를 작성
            // List에 add 할 때 new Card(카드패턴) 형태로
            // Card 객체를 만들어서 이 객체 정보를 List에 추가하겠다는 것을 의미

            // CPatternReview.checkPatternByIndex(i)
            // CpatternReview에 있는 checkPatternByIndex(i) 메소드를 호출함을 의미
            // checkPatternByIndex() 메소드는 입력된 i 값에 따라 enum에 지정되어 있는 패턴을 리턴

            // 위 방식이 어렵다면
            for (int i = 0; i < MAX_CARD_NUMBER; i++) {
                CardReview card = new CardReview(CPatternReview.checkPatternByIndex(i));
                CardList.add(card);
            }

        System.out.println(CardList); // for 문 안에서 출력하면 12번 출력되니 꼭 바깥에서 출력!!!

            // 한 단계 더 푼다면
//            for (int i = 0; i < MAX_CARD_NUMBER; i++) {
//                CPatternReview pattern = CPatternReview.checkPatternByIndex(i);
//                CardReview card = new CardReview(pattern);
//                CardList.add(card);
//            }
        }
//        System.out.println(CardList);
        // 보기 이쁘게 출력되기 위해 카드 클래스의 toString()에 \n을 써주자
    }


