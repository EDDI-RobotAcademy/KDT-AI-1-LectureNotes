package utility.generator;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    public static int getSpecificEntityId (String entityName) {
        // 엔티티 맵에 해당 이름이 없다면 put 해라 (=> 데이터 넣어줘라)
        if (entityNameMappedId.get(entityName) == null) {
            entityNameMappedId.put(entityName, 1);
            return 0;
        }

        return findValueByKey(entityName);
    }

    private static int findValueByKey (String entityName) {
        int currentId = entityNameMappedId.get(entityName);
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }
}
