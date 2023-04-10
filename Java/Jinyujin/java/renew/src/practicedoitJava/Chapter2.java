package practicedoitJava;

public class Chapter2 {
    public static void main(String[] args) {
        int age = 9;
        int charge; // 요금을 여기에 선언해놓고 - 조건에 만족하면 수행할 수행문으로

        if (age < 8) {
            charge = 1000;
            System.out.println("취학 전 아동입니다.");
        } else if (age < 14) {
            charge = 2000;
            System.out.println("초등학생입니다.");
        } else if (age < 20) {
            charge = 2500;
            System.out.println("중, 고등학생입니다.");
        } else {
            charge = 3000;
            System.out.println("일반인입니다.");
        }
        System.out.println("입장료는" + charge + "원입니다");

    }
}
