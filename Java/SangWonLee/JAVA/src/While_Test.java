public class While_Test {

    public static void main(String[] args) {

        int idx = 0;
        final char ch = 'A';

        while (idx < 10){
            System.out.println("idx : " + idx + ", 안녕 : " + (char)(ch + idx));
            idx++;
        }
    }
}
