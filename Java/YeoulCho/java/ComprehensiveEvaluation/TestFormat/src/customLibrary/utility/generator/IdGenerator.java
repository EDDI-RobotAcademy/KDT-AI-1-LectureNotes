package customLibrary.utility.generator;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    public static int getSpecificEntityId(String entitiyName){
        if(entityNameMappedId.get(entitiyName) == null){//엔티티이름이 없다면 넣어주자
            entityNameMappedId.put(entitiyName,1);
            return 0;
        }
        return findValueByKey(entitiyName);
    }

    private static int findValueByKey(String entityName){
        int currentId= entityNameMappedId.get(entityName);
        entityNameMappedId.put(entityName, currentId +1);
        return currentId;
    }
}
