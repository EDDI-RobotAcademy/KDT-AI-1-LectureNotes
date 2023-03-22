package array;

public class HeapStackTest {
    public static void main(String[] args) {
        final int START =0;
        final int ALLOC_ARRAY_NUMBER = 5;
        
        // Heap에 할당된 메모리 변경 금지를 요청한 것이고
        // 내부에 배치하는 것에는 영향을 받지 않기 때문이므로
        // final 사용 가능
        final int[] numberArray = new int[ALLOC_ARRAY_NUMBER];
        
        for(int i= START; i < ALLOC_ARRAY_NUMBER; i++){
            numberArray[i] = i+1;
            // printf는 format을 출력한다는 뜻 (print + f)
            // format은 %d의 경우 정수형(int)
            // %s는 String (Java의 경우 '+'로 해결 가능)
            // %f는 float, double 등을 처리

            // printf(printf("numberArray[%d] = %d\n", i, numberArray[i])
            // 첫번째 %d에는 i가 대응하여 i값이 %d를 대체
            // 두번째 %d에는 numberArray[i]가 대응하여 numberArray[i]값이 %d를 대체
            System.out.printf("numberArray[%d] = %d\n", i, numberArray[i]);
            // 취향차이
            // System.out.println("numberArray[" + i + "] = " + numberArray);
        }
        
        // 아래와 같이 새로운 메모리를 할당해서 전달하는 것을 막고 있음
        // 객체를 상수화 하느냐 객체 내부의 값을 상수화 하느냐의 관점으로 봐야함
        // 현재는 객체를 상수화했기때문에 다른 객체 대입이 막히는 모습
        // numberArray = new int[10];

        for(final int num: numberArray){
            System.out.println("numberArray elements = " + num);
        }
    }
}
