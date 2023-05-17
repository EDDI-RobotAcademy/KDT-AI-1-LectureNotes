package practice;

public class PrintfTest {

    public static void main(String[] args) {
        int age = 10;
        String address = "경기도";

        System.out.printf("줄바꿈 기능");
        System.out.printf(" 없음");

        System.out.printf("%n줄바꿈 기능");
        System.out.printf("%n있음%n");

        System.out.printf("나의 나이는 %d살 입니다%n", age);
        System.out.printf("나의 나이는 %d살이고 사는 곳은 %s 입니다", age, address);
    }
}
