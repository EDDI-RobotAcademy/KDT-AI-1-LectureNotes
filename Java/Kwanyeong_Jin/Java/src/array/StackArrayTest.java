package array;

public class StackArrayTest {
    public static void main(String[] args) {
        final int START = 0;
//        배열을 만드는 방법 ( final 사용 X)
//        1. 데이터 타입을 적고 []
//        2. 변수 선언하듯 변수 이름 작성
//        3. 필요시 {}열고 초기화 하거나 new 데이터타(1번) [] 형태로
//           Heap에 메모리 할당을 강제할 수 있음
        final int[] numberArray = {1,2,3,4,5};
//        여기서 이야기 한 Heap과 대조되는 것이 Stack
//        현재 위 코드는 Stack이라는 지역 변수에 설정하는 배열이며
//        new를 통해 할당하는 경우엔 Heap이라는 공간에 할당
//        우리는 로우 시스템 개발자가 아니므로 더 깊게 들어갈 필요 없음
//        new를 했기 때문에 Heap에 있구나 정도만
//
//        Stack과 Heap의 차이는?
//        Stack은 주사위 문제에서도 봤듯이 반복문 { final int data } 형태가 있다면
//        data 변수가 루프마다 초기화됨
//        이러한 지역변수 특성을 가진 것들은 모두 Stack
//        반면 new를 해서 Heap에 설정된 정보들은 메모리에 상주하여 언제 어디서든
//        데이터에 접근이 가능
//
//        ** Stack은 {}안에서 사용 / Heap은 new 하고 이후로 사용
//        배열의 경우 아래와 같이 numberArray.length 형태로 전체 길이를 파악 가능
        for (int i = START; i < numberArray.length; i++) {
//            배열은 메모리 공간상에 순차적으로 배치
//              0   1   2   3   4
//            [  ][  ][  ][  ][  ]
//
//            배열의 시작은 0부터이며 1~100이라고 하지만 배열은 0~99임
//            final int[] numberArray = {1,2,3,4,5}; 시
//            numberArray[1]은 2 / numberArray[2]은 3 / numberArray[3]은 4
//            for문에서 i값이 증가함에 따라 모든 배열의 원소를 출력
            System.out.println("배열 출력 : " + numberArray[i]);
        }

//        for의 변형 버전 foreach라고도 이야기함
//        foreach 사용법
//        1. 배열의 데이터 타입을 작성
//        2. 배열의 원소를 표현할 이름을 지정
//        3. 콜론  + 배열명

        for (int num: numberArray){
            System.out.println("배열 원소 출력 : " + num);
        }
//        서비스가 커져 데이터 규모가 컸졌다면
//        for(초기화; 조건; 증감)과 foreach중 무엇이 더 좋을까?
//
//        for 사용시 초기화나 조건등이 있어 향후 변경에 유리
//        foreach 사용시 for는 계속 조건식을 검사해야하므로 상대적으로 속도가 느림
//
//        데이터를 요청하면 필요한 정보만 선별해서 쏘게 됩니다
//        서비스 관점에선 이런 조각 내기 개념으로서 Paging이라는 것을 합니다.
//        OS 레벨에서 이야기하는 Paging과는 다른 개념

    }
}
