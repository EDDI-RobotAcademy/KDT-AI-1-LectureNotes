package homework;





public class BasicTest {
    public static void main(String[] args) {
        for (int i = 1 ; i < 101 ; i++) {
            if ( i % 2 == 0) {
                System.out.println(i);
            }
            if ( i % 3 == 0) {
                System.out.println(i);
            }
        }
        for (int i = 1 ; i < 101 ; i++) {
            if ( i % 3 == 0) {
                System.out.println(i);
            }
        }
        for (int i = 1 ; i < 101 ; i++) {
            if ( i % 4 == 0) {
                System.out.println(i);
            }
        }


    }
}
