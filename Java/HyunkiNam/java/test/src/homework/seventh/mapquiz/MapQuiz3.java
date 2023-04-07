package homework.seventh.mapquiz;

import utility.generator.SquenceGenerator;

import java.util.HashMap;
import java.util.Map;

class PhoneNumber{
    final String number;
    public PhoneNumber(String number){
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}

public class MapQuiz3 {
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber("010-4567-8901");
        PhoneNumber phoneNumber2 = new PhoneNumber("010-4567-8901");
        PhoneNumber phoneNumber3 = new PhoneNumber("010-4567-8901");
        PhoneNumber phoneNumber4 = new PhoneNumber("010-4567-8901");
        PhoneNumber phoneNumber5 = new PhoneNumber("010-4567-8901");

        Map<Integer, String> phoneNumberMap = new HashMap<>();

        phoneNumberMap.put(
                SquenceGenerator.getSpecificEntityId("quickNumber"),
                phoneNumber.getNumber());
        phoneNumberMap.put(
                SquenceGenerator.getSpecificEntityId("quickNumber"),
                phoneNumber2.getNumber());
        phoneNumberMap.put(
                SquenceGenerator.getSpecificEntityId("quickNumber"),
                phoneNumber3.getNumber());
        phoneNumberMap.put(
                SquenceGenerator.getSpecificEntityId("quickNumber"),
                phoneNumber4.getNumber());
        phoneNumberMap.put(
                SquenceGenerator.getSpecificEntityId("quickNumber"),
                phoneNumber5.getNumber());

        System.out.println(phoneNumberMap);
    }
}
