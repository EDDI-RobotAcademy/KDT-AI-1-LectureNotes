package Basic_Grammar;

public class While_Test {

    public static void main(String[] args) {

        int idx = 0;
        final char ch = 'A';

        while (idx < 10){
            System.out.println("idx : " + idx + ", 안녕 : " + (char)(ch + idx));
            idx++;
        }// 'A' 는 유니코드 65 다
/*
idx : 0, 안녕 : A
idx : 1, 안녕 : B
idx : 2, 안녕 : C
idx : 3, 안녕 : D
idx : 4, 안녕 : E
idx : 5, 안녕 : F
idx : 6, 안녕 : G
idx : 7, 안녕 : H
idx : 8, 안녕 : I
idx : 9, 안녕 : J
*/

    }
}
