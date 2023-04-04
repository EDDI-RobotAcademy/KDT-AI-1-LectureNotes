package practice.practice4;

// 3. 1 ~ 100까지 숫자중 4의 배수를 더한 결과를 출력해보자!
public class Use4 {

    int sumI = 0;

    public Use4() {
        for (int i = 1; i <= 100; i++) {

            if (i % 4 == 0) {
                // 4의 배수인 i끼리 더해줘야함
                sumI += i;}
        }
        System.out.println("4의 배수 합: " + sumI);
    }
}
