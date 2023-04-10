package problems.prob12;
// 랜덤으로 반 학생들 20명의 점수를 생성 후, 평균 계산 프로그램 작성.
// 학생들의 점수를 정렬하여 순위를 출력.
import java.util.Scanner;
public class Problem12 {
    public static void main(String[] args) {
        int MIN = 0;
        int MAX = 100;
        int START = 0;
        int END = 20;

        Scanner sc = new Scanner(System.in);
        int[] array = new int[20];
        for(int i = START; i < END; i++) {
            array[i] = (int)(Math.random() * (MAX - MIN + 1) + MIN);
            System.out.println("학생들의 점수 : " + array[i]);
        }
        int sum = 0;
        for(int i = START; i < END; i++) {
            sum += array[i];
        }
        System.out.println("학생 20명의 랜덤 점수 평균 : " + sum/END);

    }
}
