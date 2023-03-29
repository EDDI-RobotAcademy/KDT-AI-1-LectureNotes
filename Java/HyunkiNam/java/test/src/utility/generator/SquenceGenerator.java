package utility.generator;

import java.util.HashMap;
import java.util.Map;

public class SquenceGenerator {
    private static int memberId = 0;

    public static int getCurrentSequenceMemberId(){
        return memberId++;
    }

    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    // 사용자가 임의의 entity id 값을 얻고자 할 때
    // entity 이름에 해당하는 Key 값을 입력으로 넣으면
    // 현재 entityNameMappedId에서 Key에 대응하는
    // Value를 꺼내서 리턴하는 방식으로 구현
    public static int getSpecificEntityId (String entityName) {

        // map 객체에서 get()은 Key값을 토대로 Value 값을 찾는 행위
        // Key로 검색을 했으나 정보가 없다면 null 리턴
        if (entityNameMappedId.get(entityName) == null) {
            // map 객체에서 put()은 put(Key, Value) 형태로 동작
            entityNameMappedId.put(entityName, 1);
            return 0;
        }

        return findValueByKey(entityName);
    }

    private static int findValueByKey (String entityName) {
        // get()을 통해 Key 값을 던지고 Value 값을 얻는다.
        int currentId = entityNameMappedId.get(entityName);
        // put()을 통해 Key의 Value 값을 1 증가시킨다.
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }
}
