import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
//        // sout == System.out.println --- 2023/03/20
//        System.out.println("안녕 자바!");
//        // 2023/03/21 추가
//        System.out.println("변경 내역 추가");
//        // 2023/03/21 --- 추가
//        System.out.println("새로운 내역 추가");

        int[] score;

        score = new int[]{1, 2, 3, 4, 5, 6};
        int sum = 0;
        for (int i = 0; i < 6; ++i) {
            sum += score[i];
        }
        System.out.println(sum);
        int[] tt = new int[3];
        System.out.println(tt);
        test(new int[] {1, 2, 3, 4, 5, 6});
    }
    public static void test(int[] score) {
        for (int i = 0; i < 6; ++i) {
            System.out.println(score[i]);
        }
    }
}