package chapter2;

public class Function {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 30;

        int sum = addNum(num1, num2); // 함수 호출 --> Stack 메모리
        System.out.println(sum);
    }

    public static int addNum(int n1, int n2){  // 함수 선언 n1과 n2는 addNum 이라는 함수에서 새로 선언한 변수
        int result = n1 + n2;
        return result;
    }
}
