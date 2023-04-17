package customLibrary.utility.generator;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {

    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    public static int getSpecificEntityId (String entityName) {


        // entityName을 넣어서 값이 없다면 key 값에 1을 넣는다
        if (entityNameMappedId.get(entityName) == null) {
            entityNameMappedId.put(entityName, 1);
            return 0;
        }

        return findValueByKey(entityName);
    }

    // static을 통해 메모리에 상시 탑재
    // entityName을 key값으로 받아서 currentId라는 value로 return
    private static int findValueByKey (String entityName) {
        int currentId = entityNameMappedId.get(entityName);
        // 이러한 맵에 value 값을 +1해서 넣고난후 이전 value값을 return
        // 다음에 들어오는 id 순서에 따라 value값이 +1된다
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;
    }
}