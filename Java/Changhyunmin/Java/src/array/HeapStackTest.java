package array;

public class HeapStackTest {
    public static void main(String[] args) {
        final int START = 0;
        final int ALOC_ARRAY_NUMBER  = 5;

        //Heap에 할당된 메모리 변경금지를 요청한것이고 내부에 배치하는 것에는 영향을 받지 않기 때문임.
        int[] numberArray  = new int[ALOC_ARRAY_NUMBER];

        for(int i = START; i < ALOC_ARRAY_NUMBER; i++) {
            numberArray[i] = i + 1;
            //printf의 경우 format을 출력한다는 뜻으로 printf 입니다.
            //format는 %d의 경우 정수화(int)
            //%s의 경우(String)인데 필요없죠 java는 + 가 되니까요
            //%f의 경우엔 (float, double)등을 처리합니다.

            //printf("numberArray[%d]  = %d\n", i,numberArray[i])
            //위 케이스에서 첫 번째 %와 두번째 %d 가 보입니다. 첫 번째는 '.i'가 대응해서 i 값이 %d 를 대체하게 됩니다.
            //두번째는 'numberArray[i]'가 대응해서 numberArray[i]에 해당하는 배열값이 %d 를 대체합니다
            System.out.printf("numberArray[%d]  = %d\n", i,numberArray[i]);
            //System.out.println("numberArray[" + i + "] = " + numberArray[i]);
            //아래와 같이 새로운 메모리를 할당해서 전달하는 것을 막고 있습니다.
            //조금 풀어보자면 객체를 상수화 하느냐 객체 내부에 값을 상수화 하느냐의 관점으로 봐야합니다.
            //현제 관점은 객체를 상수화하였기 때문에 다른 객체 대임이 막히는 모습입니다.
            //numberArray = new int[8];
            System.out.println();
            //for (final int num : numberArray) {
            for (int num : numberArray) {
                System.out.println("numberArray elem" + num);
            }
        }

    }
}
