package rewiew.eTReview;

import java.util.regex.Pattern;

public class JETReview {
    public static void main(String[] args) {
        PReview testPattern = PReview.TUV; // Pattern 클래스 생성
                                           // 나는 PReview 라는 이름으로 생성할 것임

        System.out.println(testPattern); // TUV 출력
        System.out.println(testPattern.getValue()); // PReview 클래스에서 getter를 만들지 않으니
                                                    // 여기서 오류 발생 -> getter 만들어주러 가자
        // 여기서 PReview 클래스에 toString()을 사용해주니
        // getter 필요없이 name과 value값 출력 가능
        // getter와 toString()의 차이
        // 정보를 외부에서 뽑아서 사용하는 경우가 없다면 getter를 만들어 줄 필요가 없음
        // 단순히 출력 목적을 가지고 있을 때 toString() 사용
        // getter는 외부의 작업을 진행하면서 내부의 정보가 필요할 때
        // 내부 정보를 확보하기 위한 목적으로 만드는 것이 좋다

        for (PReview pattern : PReview.values()
             ) {
            System.out.println("Patter name: " + pattern + ", value: " + pattern.getValue());
        } // 패턴이름과 밸류값 출력

        // foreach?
        // foreach: for의 변형버전
        // for의 사용법
        // 1. for 적고 소괄호() 적고 중괄호{} 적어주기
        // 2. 먼저 소괄호 안에 배열의 데이터 타입을 작성 ex) int
        // 3. 배열의 원소를 표현할 이름을 적당히 지정 ex) number
        // 4. 콜론(:) 하나 찍기
        // 5. 정보를 하나씩 꺼내 올 배열 적어주기 ex) numberArray
        // 6. 소괄호 닫고 중괄호에 조건식이 참일 때 수행할 수행문 적어주기
        // for (int number : numberArray) {
        //            System.out.println("배열 원소 출력: " + num);
        // }
    }
}



