package array;

public class HeapStackTest {
    public static void main(String[] args) {
        final int START = 0;
        final int ALLOC_ARRAY_NUMBER = 5;

        // Heap에 할당된 메모리 변경 금지를 요청한 것이고
        // 내부에 배치하는 것에는 영향을 받지 않기 때문임.
        final int[] numberArray = new int[ALLOC_ARRAY_NUMBER]; //그냥 final 붙여서 사용하기

        for(int i = START; i < ALLOC_ARRAY_NUMBER; i++) {
            // final int i 쓰지 못하는 이유는 i 값 자체가 증가하기 때문에 쓸수 없다.

            numberArray[i] = i + 1;
            //printf의 경우 format을 출력한다는 뜻으로 printf 입니다.
            //format은 %d의 경우 정수형 (int)
            //%s의 경우 (String)인데 필요없조 java는 +가 되니까요
            //%f의 경우엔 (float, double)등을 처리합니다.

            // printf("numberArray[%d] = %d\n", i, numberArray[i])
            // 위 케이스에서 첫번째 %d와 두번째 %d 가 보입니다.
            // 첫번째는 ', i' 가 대응해서 i 값이 %d를 대처하게 됩니다.
            // 두번째는 ', numberArray[i]' 가 대응해서
            // numberArray[i]에 해당하는 배열값이 %d를 대체합니다.
            System.out.printf("numberArray[%d] = %d\n", i, numberArray[i]);
           //System.out.println("numberArray[" + i + "] = " + numberArray[i]);
        }

        // """"final"""" int[] numberArray했기 때문에
        // 아래와 같이 새로운 메모리를 할당해서 전달하는 것을 막고 있습니다.
        // 조금 풀어보자면 객체를 상수화 하느냐
        // 객체 내부의 값을 상수화 하느냐의 관점으로 봐야합니다.
        // 현재 관점은 객체를 상수화 하였기 때문에 다른 객체 대입이 막히는 모습입니다.
        // 메모리에 잡힌다는것 자체가 객체이다.
        // new를 쓴다는 것은 새로운 매모리 객체를 대입한다는 뜻.
        //numberArray = new int[8];
        System.out.println();

        for (final int num: numberArray) {
            // final int num이라고 써도 stack이기 때문에 다음 num 에서 초기화가 된다.
            // fianl 사용할수 있는 이유는 numberArray 에서 바로 뽑아와서 쓰기때문에 가능하다.
            System.out.println("numberArray elem: " +num);
        }
    }
}
