package utility.genrtator;

import java.util.HashMap;
import java.util.Map;

public class SequenceGenerator {
    //Map 객체 만드는법
    //1.Map<키 데이터타입, 벨류 데이터타입>을 작성합니다.
    //2.변수 이름을 작성하듯 Map 타입의 변수명을 작성합니다.
    //3.new HashMap<>(); 형태로 객체를 초기화 합니다.

    //Entity란 무엇인가?
    //엔티티는 핵심 업무 규칙입니다.
    //도대체 뭐가 핵심 업무 규칙일까요?
    //비즈니스 상 다루고자 하는 정보 <- 보편적으로 Life cycle을 가짐
    //ex) 회원정보.

    //아래 코드의 개념이 확장되면 DB에서 @Entity 어노테이션과 @Id 형태로 처리됩니다.
    //JPA에서  아래와 같은 entity의 id 값을 자동으로 관리 해줍니다.
    //방식은 동일하기 때문에 추후 자연스럽게 연결 될 것 이라고 판단한다
    private static Map<String, Integer> entituNameMappedId = new HashMap<>();
    //사용자가 id값을 설정한다면
    //entity 이름에 해당하는 key값을 입력으로 넣으면
    //현재 entituNameMappedId에서 key에 대응하는
    // value를 꺼내서 리턴하는 방식으로 구현
    public static int getSpecificEntityId(String entityName) {
        if (entituNameMappedId.get(entityName) == null){
            entituNameMappedId.put(entityName, 1);
            return 0;
        }
        return findValueByKey(entityName);
    }
    private static int findValueByKey(String entityName){
        int currentId = entituNameMappedId.get(entityName);
        entituNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }


}
