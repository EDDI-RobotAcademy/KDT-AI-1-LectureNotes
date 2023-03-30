package homework;

import java.util.HashMap;
import java.util.Map;


public class basicMap {
    private static Map<String, Integer> nameAge = new HashMap<>();
    private static Map<String, Integer> nameNumber = new HashMap<>();
    private static Map<Integer, Integer> speedNumber = new HashMap<>();
    private static Map<String, String> nickReal = new HashMap<>();
    public static void main(String[] args) {

        String name = "Han" ;
        String name2 = "Kim" ;
        int shortNumber = 01 ;
        String nickName = "tall" ;


        nameAge.put(name, 12);
        int age = nameAge.get("Han");
        nameNumber.put(name2, 5905);
        int Number = nameNumber.get("Kim");
        speedNumber.put(shortNumber, 12);
        int longNumber = speedNumber.get(01);
        nickReal.put(nickName, "Son");
        String realName = nickReal.get("tall");

        System.out.println("name : "+ name + " age:" + age);
        System.out.println("name : "+ name2 + " Number " + Number);
        System.out.println("short number : "+ shortNumber + " long number:" + longNumber);
        System.out.println("nick name : "+ nickName + " real name:" + realName);

    }
}
