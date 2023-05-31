package problems.prob16;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    static Map<String, Integer> entityNameMappedID  = new HashMap<>();
    private static int findValueByKey(String entityName){
        int CurrentID = entityNameMappedID.get(entityName);
        entityNameMappedID.put(entityName, CurrentID + 1);
        return CurrentID;

    }

    static int getSpecificEntityID  (String entityName){

        if (entityNameMappedID.get(entityName) == null){
            entityNameMappedID.put(entityName,1);
            return 0;
        }
     return findValueByKey(entityName);
    }

}
