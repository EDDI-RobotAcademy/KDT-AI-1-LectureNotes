package problem.mapProb1;

import java.util.HashMap;
import java.util.Map;

class PersonAgeMap {
    private Map<String, Integer> personInfo = new HashMap<>();

    public void setPersonAge(String name, int age) {
        personInfo.put(name, age);
    }

    public int getPersonAge (String name) {
        return personInfo.get(name);
    }

}

public class PersonAge {
    public static void main(String[] args) {
        PersonAgeMap personAgeMap = new PersonAgeMap();
        final String name1 = "철수";
        final int age1 = 20;
        personAgeMap.setPersonAge(name1, age1);

        final String name2 = "영희";
        final int age2 = 19;
        personAgeMap.setPersonAge(name2, age2);

        System.out.println(name1 + "의 나이는: "
                + personAgeMap.getPersonAge(name1));
        System.out.println(name2 + "의 나이는: "
                + personAgeMap.getPersonAge(name2));
        System.out.println(personAgeMap);
    }
}
