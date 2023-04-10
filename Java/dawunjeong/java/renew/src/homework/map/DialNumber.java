package homework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DialNumber {
    public static void main(String[] args) {

        final Map<Integer, Integer> dialnumber = new HashMap<>();

        final int dial;
        final int phoneNumber;
        int findPhoneNumber;

        Scanner scan = new Scanner(System.in);
        System.out.println("단축번호와 전화번호를 입력하세요.");
        dial = scan.nextInt();
        phoneNumber = scan.nextInt();

        dialnumber.put(dial,phoneNumber);

        System.out.println("단축번호로 전화번호를 조회하세요.");
        findPhoneNumber = scan.nextInt();

        if(dialnumber.get(findPhoneNumber) == null){
            System.out.println("등록되어 있지 않습니다.");
        } else {
            System.out.println(dialnumber.get(findPhoneNumber));
        }

    }
}
