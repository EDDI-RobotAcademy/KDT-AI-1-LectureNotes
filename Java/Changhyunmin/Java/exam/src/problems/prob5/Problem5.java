package problems.prob5;

public class Problem5 {
    public static void main(String[] args) {// 5번PASS
        //5. 아래와 같은 숫자 나열이 있습니다. 3, 3, 3, 6, 9, 12, 18, 27, 39, 57,
        // … 이 숫자 나열의 20번째엔 어떤 숫자가 있을지 프로그램을 작성해보세요.
        int Sum = 0;
        for (int i = 0; i < 30; i +=3){
            Sum += i + 3;
            System.out.println(Sum);

        }

    }
}
