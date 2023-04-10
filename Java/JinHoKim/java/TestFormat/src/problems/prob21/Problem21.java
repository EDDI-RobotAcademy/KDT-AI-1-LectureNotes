package problems.prob21;

import customLibrary.prob21.Employees;

public class Problem21 {
    public static void main(String[] args) {
        //문제 21번
        //연봉인상률 랜덤으로 지정
        Employees employees = new Employees();
        employees.randomIncreaseRate();
        //이름 만들기



        // 배열과 리스트의 차이점
        System.out.println("배열은 정해지 공간이 있고 식별자가 존재한다" +
                "리스트는 식별자가 없으며 배열과 달리 크기를 할당할 필요가" +
                "없다 ");
    }
}
