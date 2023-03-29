package utility.generator;

import java.util.HashMap;
import java.util.Map;

public class SequenceGenerator {

    // Map 활용 방법
    // 1. Map<키 데이터타입, 밸류 데이터타입>을 작성한다.
    // 2. 변수 이름을 작성하듯 Map 타입의 변수명을 작성한다.
    // 3. new HashMap<>(); 형태로 객체를 초기화 한다.

    // Entity란 무엇인가?
    // 엔티티는 핵심 업무 규칙이다.
    // 도대체 뭐가 핵심 업무 규칙일까 ?
    // 비즈니스 상 다루고자 하는 정보 <- 보편적으로 Life Cycle을 가진다. (사용자 정보도 life cycle이다.)

    // 아래 코드의 개념이 확장되면 DB에서는 @Entity 어노테이션과 @Id 형태로 처리된다.
    // JPA에서 아래와 같은 entity의 id 값을 자동으로 관리해준다.
    // 방식은 동일하기 때문에 추후 자연스럽게 연결 될 것이라 판단된다.
    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    private static int currentMemberId = 0;

    // 사용자가 임의의 entity id 값을 얻고자 할 때
    // entity 이름에 해당하는 Key 값을 입력으로 넣어서
    // 현재 entityNameMappedId에서 Key에 대응하는
    // Value를 꺼내서 리턴하는 방식으로 구현
    public static int getSpecificEntityId (String entityName) {
        // map 객체에서 get()은 Key값을 토대로 Value 값을 찾는 행위이다.
        // Key로 검색을 했으나 정보가 없다면 null을 리턴한다.
        if(entityNameMappedId.get(entityName) == null){
            // map 객체에서 put()은 put(key, value) 형태로 동작한다.
            entityNameMappedId.put(entityName, 1);
            return 0;
        }

        return findValueByKey(entityName);
    }

    private static int findValueByKey(String entityName){
        // get()을 통해 Key 값을 던지고 Value 값을 얻는다.
        int currentId = entityNameMappedId.get(entityName);
        // put()을 통해 Key의 Value 값을 1 증가시킨다.
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }
}