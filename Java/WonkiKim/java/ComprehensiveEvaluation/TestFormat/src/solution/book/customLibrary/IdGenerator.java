package solution.book.customLibrary;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {

    private static Map<String, Integer> entityNameMappedId = new HashMap<>();

    public static int getSpecificEntityId (String entityName) {
//entityName이 entityNameMappedId 해쉬맵에 키값으로 존재하지 않다면 1을 밸류로 갖고 0을 리턴 (ex. 한명도 회원가입 x)
        if (entityNameMappedId.get(entityName) == null) {
            entityNameMappedId.put(entityName, 1);
            return 0;
        }

        return findValueByKey(entityName);
    }

    private static int findValueByKey (String entityName) {// entityName이 entityNameMappedId해쉬맵에 존재한다면
        //(ex. 1명이상 회원가입 했다면.)
        int currentId = entityNameMappedId.get(entityName);
        entityNameMappedId.put(entityName, currentId + 1);
        return currentId;// 그 entity의 value의 현재값을 리턴하고 1증가.
    }
}
