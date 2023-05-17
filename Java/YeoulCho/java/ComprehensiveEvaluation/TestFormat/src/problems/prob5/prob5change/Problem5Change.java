package problems.prob5.prob5change;

public class Problem5Change {


        public static void findIdx(int Idx) {
            int[] A= new int[Idx];
            A[0] = 3;
            A[1] = 3;
            A[2] = 3;
            for (int i = 3; i < A.length; i++) {
                A[i] = A[i - 1] + A[i - 3];
            }
            System.out.println(A[Idx - 1]);
        }


        public static void main(String[] args) {

            findIdx(20);

        }
    }

