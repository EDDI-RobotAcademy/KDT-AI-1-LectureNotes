package array;

public class HeapStackTest {
    public static void main(String[] args) {
        final int START=0;
        final int ALLOC_ARRAY_NUMBER=5;
        //힙에 할당된 메모리 변경 금지를 요청한 것이고
        // 내부에 배치하는 것에는 영향을 받지 않기 때문임
        final int[] numberArray= new int[ALLOC_ARRAY_NUMBER];

        for (int i=START; i<ALLOC_ARRAY_NUMBER;i++){
            numberArray[i] =i+1;
            System.out.printf("numerArray[%d] = %d\n",i,numberArray[i]);
            //printf의 경우 format을 출력한다는 뜻으로 printㄹ dlqslek.
            // format은 %d의 경우 정수형
            // %s의 경우엔 스트링인데 필요없음
            // %f의 경우엔 실수형
            
            //  printf("numerArray[%d] = %d\n",i,numberArray[i]);
            // 위 코드에서 처번째 %와 i가 대응하고  두번째 %d 와 numberAraay[i]가 대응함

        }
        //아래와 같이 새로운 메모리를 할당해서 전달하는 것을 막고 있습니다.
        //조금 풀어보자면 객체를 사웃화 하느냐
        //객체 내부의 값을 상수화 하느냐의 관점으로 봐야합니다.
        //현재 관점은 객체를 상수화하였기 때문에 다른 객체 대입이 막히는 모습입니다.
        // numberArray=new int[8]

        for (int num: numberArray){
            System.out.println("numberArray elem : "+num);
        }
    }
}
