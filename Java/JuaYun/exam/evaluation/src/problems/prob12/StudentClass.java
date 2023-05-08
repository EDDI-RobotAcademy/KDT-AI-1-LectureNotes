package problems.prob12;

import problems.CustomRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 12. 랜덤으로 20명의 학생에게 점수를 생성하고 평균을 계산
// 13. 학생들의 점수를 정렬하여 순위를 출력
public class StudentClass {

    List<Integer> studentList = new ArrayList<>();

    public StudentClass() {
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            studentList.add(CustomRandom.generateNumber(0,100));
            sum += studentList.get(i);
            // 원래 작성한 코드는
            // sum += i;
            // studentList 에 넣어줬던 값을 합해야하기 때문에
            // studentList.get(i) 로 작성해줘야함
        }
        float avg = (float) sum/studentList.size();
        // 처음작성은 sum/20으로 표현했었음
        // 이후 작성한 지금의 형태가 확실히 뭘 하고자하는지 보임

        System.out.println("12번 문제. 학생들의 점수는: " + studentList);
        System.out.println("12번 문제. 평균점수는: " + avg);

        Collections.sort(studentList, Collections.reverseOrder());
        // 내림차순으로 정렬하는 방법 꼭 기억하기
        // 오름차순은 Collections.sort(studentList)
        System.out.println("13번 문제. 순위: " + studentList);
    }
}
