package utility.generator;

import java.util.HashMap;
import java.util.Map;

public class SequenceGenerator {

    // Map 객체 만드는 방법
    // 1. Map<키 데이터타입, 밸류 데이터타입> 을 작성합니다.
    // 2. 변수 이름을 작성하듯 Map 타입의 변수명을 작성합니다.
    // 3. new HashMap<>(); 형태로 객체를 초기화 합니다.

    // Entity란 무엇인가 ?
    // 엔티티는 핵심 업무 규칙입니다.
    //(+엔티티는 데이터베이스 테이블과 매핑되는 자바 클래스를 말한다.)
    // 도대체 뭐가 핵심 업무 규칙일까요 ?
    // 비즈니스 상 다루고자 하는 정보 <- 보편적으로 Life Cycle을 가짐

    // 아래 코드의 개념이 확장되면 DB에서는 @Entity 어노테이션과 @Id 형태로 처리됩니다.
    // JPA에서 아래와 같은 entity의 id 값을 자동으로 관리해줍니다.
    // 방식은 동일하기 때문에 추후 자연스럽게 연결 될 것이라 판단됩니다.
    private static Map<String, Integer> entityNameMappedId = new HashMap<>();
    //entityNameMappedId라는 Map생성, String키, Integer값

    // 사용자가 임의의 entity id 값을 얻고자 할 때
    // entity 이름에 해당하는 Key 값을 입력으로 넣으면
    // 현재 entityNameMappedId에서 Key에 대응하는
    // Value를 꺼내서 리턴하는 방식으로 구현
    public static int getSpecificEntityId (String entityName) {
        //map 객체에서 get()은 키값을 토대로 벨류값을 찾는 행위이다.
        //key로 검색을 했으나 정보가 없다면 null을 리턴한다.
        if (entityNameMappedId.get(entityName) == null) { //키:entityName에 해당하는 값이 null일때
            //map객체에서 put()은 put(key, value)형태로 동작한다.
            entityNameMappedId.put(entityName, 1);     //키:entityName, 값:1 저장
            return 0;
        }

        return findValueByKey(entityName);
    }

    private static int findValueByKey (String entityName) {
        //get()을 통해 키값을 던지고 벨류값을 얻는다.
        int currentId = entityNameMappedId.get(entityName); // currentId = 키:entityName에 해당하는 값
        //put()을 통해 키의 벨류값을 1 증가시킨다.
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }
}