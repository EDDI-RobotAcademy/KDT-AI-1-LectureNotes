package basicProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuickNumber {

    public static void main(String[] args) {

        //단축 번호와 전화 번호를 map에 저장해서 출력해봅시다.

        int quickNumber;
        int phoneNumber;

        Map<Integer, Integer> number = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("단축 번호를 입력해주세요 : ");
        quickNumber = sc.nextInt();

        System.out.println("번호를 입력해주세요 : ");
        phoneNumber = sc.nextInt();

        number.put(quickNumber, phoneNumber);

        System.out.println(number);

        System.out.println("단축 번호를 입력해주세요 : ");
        int quickNumberGo = sc.nextInt();

        System.out.println("다음 전화 번호로 연락합니다 : " + number.get(quickNumberGo));






    }

}
