package problem.mapProb1;

import java.util.HashMap;
import java.util.Map;

class PersonPhoneNumMap {
    private Map<String, Integer> personInfo = new HashMap<>();

    public void setPersonPhoneNum(String name, int phoneNum) {
        personInfo.put(name, phoneNum);
    }

    public int getPersonPhoneNum (String name) {
        return personInfo.get(name);
    }
}

public class PersonPhoneNum {
    public static void main(String[] args) {
        PersonPhoneNumMap personPhoneNumMap = new PersonPhoneNumMap();
        final String name1 = "철수";
        final int phoneNum1 = 11111111;
        personPhoneNumMap.setPersonPhoneNum(name1, phoneNum1);

        final String name2 = "영희";
        final int phoneNum2 = 22222222;
        personPhoneNumMap.setPersonPhoneNum(name2, phoneNum2);

        System.out.println(name1 + "의 나이는: "
                + personPhoneNumMap.getPersonPhoneNum(name1));
        System.out.println(name2 + "의 나이는: "
                + personPhoneNumMap.getPersonPhoneNum(name2));

    }
}
