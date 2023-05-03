package customLibrary.utility.generator;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {

    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    public static int getSpecificEntityId (String entityName) {

        if (entityNameMappedId.get(entityName) == null) {
            entityNameMappedId.put(entityName, 1);
            return 0;
        }
        // 5. HashMap이 비어있으면
        //    HashMap에 key: "Book", value: 1의 객체 추가
        //    return;

        return findValueByKey(entityName);
        // 6. findValueByKey로 entityName값 보내기
    }

    private static int findValueByKey (String entityName) {
        int currentId = entityNameMappedId.get(entityName);
        // 7. entityNameMappedId에서 key: entityName값으로 value값을 받아와 currentId를 초기화

        entityNameMappedId.put(entityName, currentId + 1);
        // 8. currentId + 1

        return currentId;
    }
}
