package kr.eddi.demo.lectureClass.testCode.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    final private List<ScoreInterface> scoreList = new ArrayList<>();

    public void add (ScoreInterface scoreInterface) {
        scoreList.add(scoreInterface);
    }

    // 평균의 종류가 여러가지 있음 (가장 기본형태인 산술 평균 - 더 해서 개수 나누기)
    public int arithmeticMean () {
        // scoreList 를 쭉 나열한 이후 mapToInt()를 통해 Integer 값으로 만듬
        // 만들 때 사용하는 매서드는 ScoreInterface 에 있는 getScore()를 사용함
        // 각각을 Integer 로 만들고 sum()을 통해 합산함

        int total = scoreList.stream().mapToInt(ScoreInterface::getScore).sum();
        //해당 코드는 ScoreInterface 를 구현한 객체들로 이루어진 리스트인 scoreList 의 요소들을 Stream 으로 처리하여,
        // 각 객체의 getScore() 메서드를 호출하여 반환된 점수를 int 타입으로 변환한 후에 합계(sum)를 계산하는 기능을 수행합니다.
        //
        //구체적으로는,
        //
        //1. scoreList.stream()은 scoreList 를 Stream 으로 변환합니다.
        //2. .mapToInt(ScoreInterface::getScore)은 Stream 의 요소를
        // ScoreInterface::getScore 메서드로 매핑하여 int 타입의 요소 Stream 으로 변환합니다.
        // 즉, ScoreInterface 객체에서 getScore() 메서드를 호출하여 반환된 값을 int 타입으로 변환합니다.
        //3. .sum()은 int 타입의 요소 Stream 에서 모든 요소를 더한 합계를 계산하여 반환합니다.
        //
        //따라서, 위 코드는 scoreList 의 각 객체에서 getScore() 메서드를 호출하여 반환된 점수의 합계를 계산하는 코드입니다.

        // Stream 은 데이터 처리를 간결하게 작성하고 성능을 향상시킬 수 있도록 도와주는 유용한 기능입니다.

        // 넷째, Stream 은 람다 표현식과 함께 사용하여 코드를 간결하게 작성할 수 있습니다.
        // 람다 표현식은 함수형 프로그래밍을 지원하므로, Stream 을 사용하여 데이터를 처리하는 경우
        // 람다 표현식을 이용하여 코드를 작성할 수 있습니다.

        //mapToInt()
        //Java 8에서 추가된 Stream API 에서 .mapToInt() 메서드는 Stream 의 요소들을
        // int 타입의 값으로 변환하여 IntStream 으로 리턴하는 메서드입니다.

        //Java 8에서 추가된 IntStream 인터페이스에서 sum() 메서드는
        // IntStream 의 모든 요소들을 더한 결과를 반환하는 메서드입니다.

        //Collection 인터페이스는 다른 인터페이스들과 함께 JDK 에서 제공하는 인터페이스들 중
        // 가장 기본이 되는 인터페이스 중 하나입니다.


        //스트림(Stream)은 자바 8에서 추가된 기능으로, 컬렉션(Collection)의 요소를
        // 람다식으로 처리할 수 있도록 지원하는 함수형 프로그래밍의 기능입니다.


        return total / scoreList.size();
    }
}