package problemBank.dice1;

public class Dice1_1 {
    public static void main(String[] args) {
        int MAX = 6;
        int MIN = 1;

        int DICENUMBER1 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
        int DICENUMBER2 = (int)(Math.random() * (MAX - MIN +1)) + MIN;
        System.out.println("첫번째 주사위 : " + DICENUMBER1 + ", 두번째 주사위 : " + DICENUMBER2);
        // Random 메서드
        // Math.random();은 그냥 출력하면 0보다 크고 1보다 작은 값을 출력해낸다.
        // 즉, 0 < N < 1 이라 표현할 수 있다.

        // 1부터 100까지의 정수를 출력하고자 한다면,
        // 정수부분만 사용하면 되므로 (int)를 사용해 캐스팅해준다.
        // (int)(Math.random()*100);
        // 이는 0 < N < 100의 범위를 갖는다.
        // 여기에 1을 더하면 1 < N < 101 의 범위가 되므로
        // int를 통해 1부터 100까지의 정수를 출력할 수 있다.

        // 정리하자면, "Math.random() * 숫자" 는
        // 입력한 숫자보다 작지만 무한히 가까운 수를 만들어낸다.

        // 위에서 사용한 메서드를 활용해서 원하는 정수 범위만 나오도록 할 수 있다.
        // "(int) Math.random() * (최댓값-최소값+1) + 최소값"
        // 으로 최솟값과 최댓값 사이의 정수만 나오도록 만든 메서드다.

        // 3에서 10까지의 정수 범위를 만드는 과정 {3, 4, 5, 6, 7, 8, 9, 10}
        // (Math.random() * 10) -> 0 < N < 10
        // (Math.random() * 10) + 3 -> 최솟값이 3이므로 3을 더해준다. -> 3 < N < 13
        // (Math.random() * (10 - 3)) + 3 -> 최대값이 13이되어서 범위 10에서 3을 빼주었다.
        //                                -> 3 < N < 10 -> {3, 4, 5, 6, 7, 8, 9}
        // (Math.random() * (10 - 3 + 1)) + 3
        //  └ 10 미만의 범위가 도출되어 10이라는 정수는 나오지 않으므로 최댓값과 최솟값의 차에서 1을 더해준다.
        //    -> 3 < N < 11 -> {3, 4, 5, 6, 7, 8, 9, 10}
        // 즉, (Math.random() * (최댓값 10 - 최솟값 3 + 1))) + 최솟값 3 이 되므로
        // 앞에 (int)를 사용하여 3에서 10까지의 정수를 나오게 할 수 있다.

        int SUM = DICENUMBER1 + DICENUMBER2;
        System.out.println("두 주사위의 합 : " + SUM);

        if (SUM % 4 == 0) {
            System.out.println("승리");
        } else {
            System.out.println("패배");
        }
    }
}


// 주사위 문제 [1]
// 주사위 2개, 합이 4의 배수가 된다면 승리
// class없이 풀어보기

// 주사위 두개에 대한 변수설정하기
// 1. 각각 하나씩 설정해서 만들기, Dice1_1
// 2. for문으로 돌려서 List 사용해서 만들기, Dice1_2
// 필요한 개념 : int, for, List, Array?