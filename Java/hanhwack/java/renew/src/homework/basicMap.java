package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class basicMap {
    private static Map<String, Integer> nameAge = new HashMap<>();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        nameAge.put("Han", 12);
        int age = nameAge.get("Han");

        System.out.println(age);

    }
}
