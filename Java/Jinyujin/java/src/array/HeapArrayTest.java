package array;

public class HeapArrayTest {
    public static void main(String[] args) {
        final int START = 0;
        final int ALLOC_ARRAY_NUMBER = 5;

        // Heap에 할당된 메모리 변경 금지를 요청한 것이고
        // 내부에 배치되는 것에는 영향을 받지 않기 때문임.
        final int[] numberArray = new int[ALLOC_ARRAY_NUMBER];
        //... new는 StackArrayTest에서 확인 가능
        // new를 했기 때문에 Heap이 있다고 이해하면 OK

        // 여기서는 final int i 불가능 - i 값이 증가하는 것이기 때문에
        for (int i = START; i < ALLOC_ARRAY_NUMBER; i++) {
            numberArray[i] = i + 1;
            // printf의 경우 format(형식)을 출력한다는 뜻
            // format은 %d의 경우 정수형(int)
            // %s의 경우(String)인데 필요 없죠 java는 +가 되니까요
            // %f의 경우엔 (float, double) 등을 처리합니다

            // printf("numberArray[%d] = %d\n", i , numberArray[i])
            // 위 케이스에서 첫 번째 %d와 두 번째 %d가 보입니다.
            // 첫 번째는 ', i'가 대응해서 i 값이 %d를 대체하게 됩니다.
            // 두 번째는 ', numberArray[i]' 가 대응해서
            // numberArray[1]에 해당하는 배열값이 %d를 대체합니다.
            System.out.printf("numberArray[%d] = %d\n", i , numberArray[i]);
            //... \n은 줄바꿈 문자

            //... 지저분해져서 printf로 한 것. 똑같이 하면 아래
            // == System.out.println("numberArray[" + i + "] = " + numberArray[i]);
        }

        // 아래와 같이 새로운 메모리를 할당해서 전달하는 것을 막고 있습니다.
        // 조금 풀어보자면 객체를 상수화 하느냐
        // 객체 내부의 값을 상수화 하느냐의 관점으로 봐야합니다.
        // 현재 관점은 객체를 상수화하였기 땨문에 다른 객체 대입이 막히는 모습입니다.
        // numberArray = new int [8];

        // 여기서는 못 바꾸게 하고 싶으면 final int num도 가능
        // 얘는 뽑아오는 값이기 때문에 가능하다
        for (int num: numberArray) {
            System.out.println("num: " + num);
            // == System.out.println("numberArray elem: " + num);
        }

        //... 나중에는 객체 자체도, 내부도 final 처리 가능 - 완벽한 불변이 되는 것

        //... new를 하면 무조건 메모리에 잡히고 메모리에 잡힌다는 것 자체가 객체
        // final int[] numberArray = new int[ALLOC_ARRAY_NUMBER];는 ALLOC_ARRAY_NUMBER을 상수화 한 것이고
        // 그래서 numberArray = new int [8]; 이것이 에러 나는 것
        // numberArray를 고정값으로 만들어둔건가?
        // final int Month = 12; 로 선언하고
        // 따로 Month = 13; 이라고 선언하는 것이 불가능하다.
        // final int Month = 13; 이라고 수정하는 것 가능

        // 코드 자체는 어렵지 않지만 개념이 어려움 - 공부할 것!
    }
}
