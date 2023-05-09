package com.example.demo.lambdaTest;

import com.example.demo.lectureClass.testCode.score.ScoreCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LambdaTest {
    // 여기서 ScoreTest(평균 구하기) 진행할 것임
    // 테스트 코드는 반드시 test 디렉토리 내부에서 만들어야 함
    // main에서 만들면 안됨! 이슈 생긴다는데 뭔지는 모르겠음

    /*
    처음에 이름을 검증이라고 적었음.
    근데 왜 뺏을까요 ?
    - 검증 다른데서 하려고
    - 검증이 아니라서
    - 여기서 검증을 못해서

    -> TDD때문임
    우리는 지금 DDD를 하고 있음 - 도메인에 관한 것

    TDD(Test Driven Development),
    DDD(Domain Driven Development)
    DDD를 잘 하려면 전제 조건이 TDD가 깔려야 합니다.
    DDD의 근본적인 목적은 결국 관심사를 분리해서 복잡성을 낮추는데 있음

    왜(Why) ?
    왜에 대해 생각하기 이전에 TDD는 Test를 먼저 작성하고
    이 'Test에 대응하는 코드를 만들어보자!' 가 핵심이라 보면 됩니다.

    이 내용을 기반으로 'Why' 에 대한 유추를 해보자면 ?
    - Test를 작성하면서 Domain을 파악할 수 있기 때문입니다.

    무엇이든 처음 접근하는 것은 매우 어렵습니다.
    하지만 개발자는 처음 접근하는 것에 도전 ? 하여 깨부수는 직업입니다.
    (물론 개발자도 레벨이 다양하기 때문에 요쪽은 소위 천상계라고 부릅니다)
    그리고 이 천상계로 가기 위해 반드시 필요한 작업들이 TDD, DDD 입니다.
    실제로 Java 코드를 작성할 때도 문제 전체를 한 번에 만들지 않고
    여기서 문제 자체가 요구하는 사항들을 정리하였습니다.

    - 여기서 또 팁이라면 요구 사항을 정리할 때 완벽할 필요가 없습니다.
    오히려 위의 요구 사항을 완벽하게 만드려다가 아무고토 못하고 나락으로 향하게 됩니다.
    이것의 대표적인 특징 중 하나가 회의만 오질라게 하는 회사나 그룹입니다.
    회의 백날 해봐야 결론이 안나오고 여기에 쓸모없이 소요해야 하는 시간과 비용이 매우 큽니다.
    실제로 이렇게 회의만 수 개월에서 수 년을 하다가 아무것도 못하고 사라지는 경우가 많습니다.
    그래서 Facebook에서도 이런 이야기가 있습니다.
    "Done is better than perfect!"
    일단 만들라는 것이죠.
    만들어 보면 스스로도 만든 것에서 무엇이 노답인지가 보이기 때문입니다.
    이렇게 하면 더 좋았을 것 같은데 ? 가 결국 Backlog 작성하는 관점에서 Review로 가는 것입니다.

    이 이야기는 TDD와 DDD에 연계된 철학속에 내포된 내용이고
    결론만 기억하고 싶다면 'Test가 Domain 찾기를 서포트한다' 라고 정리하면 됩니다.
    테스트를 만들고 도메인 분리를 하게 되면서 자연스럽게 알게 된다고 함

    그리고 이것 때문에 순서가 바뀌는 것이 하나 있습니다.
    TDD를 시작하게 되면 일단 실패하는 테스트 코드를 먼저 만들게 됩니다.
    (지금은 로직을 먼저 만들고 테스트를 만들었는데 테스트를 먼저 만들었어야 한다는 것)
    그리고 그 실패하는 테스트 코드를 작성하기 위해
    필요한 로직들을 작성하여 최종적으로 Test가 구동되도록 만듭니다.
    그래서 결론적으로 'Test는 Backlog 그 자체'가 됩니다.

    정리하면
    1. 실패할 수 밖에 없는(로직이 없어서) 테스트 코드를 작성합니다.
    2. 해당 테스트 코드가 동작하도록 로직을 만듭니다.
    3. 테스트 코드가 동작하여 테스트가 완료되는지 검사합니다.
    4. 실패한다면 2 ~ 3번을 반복합니다.
     */
    @Test
    @DisplayName("정수형 숫자 평균 계산")
    public void 두개의_숫자_더해서_평균_계산 () {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        // "입력이 없고, 항상 5를 반환하는 함수" 라는 뜻
        collection.add(() -> 9);
        // 디버그로 ScoreCollection의 add메서드에 의해 들어가는 것 확인가능
        // collection.add(() -> 5); 이 줄 찍고 디버그 해보면 됨 stepinto 이런거 이용
        // 람다는 () 익명의 메서드를 만들 수 있음
        // 보통 메서드를 만들면 메모리에 저장됨 -> 근데 메모리 크기가 그다지 크지 않음
        // 익명의 메서드로 보완 가능
        // "()"는 입력이 없음을 나타내며, "->"는 "이 함수는 다음과 같은 작업을 수행한다"는 뜻

        int actualResult = collection.arithmeticMean();

        assertEquals(actualResult, 7);
        // 5 + 9 / 2 = 7
        // assertEquals(actualResult, 6); 으로 하면 테스트 실패함
        // 당연함 결과는 7이니까
        // assertEquals 둘이 같으면 패스, 아니면 실패
        // 잘모르는 코드 나온다면 디버그 해보는게 도움이 된다고 함
    }
}
