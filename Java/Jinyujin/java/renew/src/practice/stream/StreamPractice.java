package practice.stream;

import java.util.ArrayList;
import java.util.List;

// 스트림 사용하기
// 고객의 명단 출력
// 여행의 총 비용 계산
// 고객 중 20세 이상인 사람의 이름을 정렬하여 출력
public class StreamPractice {
    public static void main(String[] args) {

        // 고객의 명단 출력 - 내가 만드는 거였음
        TravelCustomer travelCustomerKim = new TravelCustomer("김이름", 20, 200000);
        TravelCustomer travelCustomerPark = new TravelCustomer("박민수", 16, 9879516);
        TravelCustomer travelCustomerJung = new TravelCustomer("정네임", 34, 550196);

        List<TravelCustomer > travelCustomerList = new ArrayList<>();
        travelCustomerList.add(travelCustomerKim);
        travelCustomerList.add(travelCustomerPark);
        travelCustomerList.add(travelCustomerJung);

//        Stream<TravelCustomer> travelCustomerStream =


        // 여행의 총 비용 계산

    }
}
