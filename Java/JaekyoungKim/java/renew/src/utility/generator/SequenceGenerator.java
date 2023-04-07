package utility.generator;

import java.util.HashMap;
import java.util.Map;

public class SequenceGenerator {
    //맵 활용 방법
    //1. Map<키 데이터 타입, 밸류 데이터 타입>을 작성합니다.
    //2. 변수 이름을 작성하듯 Map 타입의 변수명을 작성합니다.
    //3. new HashMap<>();형태로 객체를 초기화 합니다.
    // 열쇠가 있는 상자의 키와 공간이 있는 느낌
    // 10명이 있다가 7명이 나간다고 4번부터 시작이 아니라 11번부터 다음 사람이 시작된다.

    // Entity란 무엇인가?
    // 엔티티 핵심 업무 규칙
    // 도대체 뭐가 핵심 업무 규칙인 것인가?
    // 서비스를 만드는 데 있어 가장 중요한 규칙.
    // 서비스 하려고 하는 주체가 무엇인가?
    // 비즈니스 상 다루고자 하는 정보<- 보편적으로 Life Cycle을 가짐- 사용자 정보도 엔티티임
    //아래 코드의 개ㅕㄴㅁ이 확장되면 DB에서는 @entity 어노테이션과 @Id 형태로 처리됩니다.
    //JPA에서 아래와 같은 entity의 id 값을 자동으로 관리해줍니다.
    //방식은 동일하기 때문에 추후 자연스럽게 연결 될 것이라 판단됩니다.

    private static Map<String, Integer> entityNameMappedId=new HashMap<>();

    //사용자가 id 값을 얻고자 할 때
    // 현재 entityNameMappedId에서 Value를 꺼내서 리턴하는 방식으로 구현.


    //static int 보다 조금 더 자동화 하기에 괜찮은 방식이 있다.
    //

    public static int getSpecificEntityId (String entitiyName) {
        //map 맵 객체에서 get()은 Key값을 토대로 Value값을 찾는 행위입니다.
        //Key로 검색을 했으나 정보가 없다면 null을 리턴합니다.
        if (entityNameMappedId.get(entitiyName)==null){
            entityNameMappedId.put(entitiyName,1);
            //map 객체에서 put()은 put(Key,Value) 형태로 동작합니다.

            return 0;
        }
        return findValueByKey(entitiyName);
    }
    private static int findValueByKey(String entityName){
        //get을 통해 Key값을 던지고 Value 값을 얻습니다.
        int currentId=entityNameMappedId.get(entityName);
        //put 을 통해 key 값을 1 증가 시킵니다.
        entityNameMappedId.put(entityName,currentId+1);
        return currentId;

    }
}
