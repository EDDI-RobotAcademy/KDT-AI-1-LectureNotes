package problems.prob4;

public class Problem4 {
    public static void main(String[] args) {

        int numberMin = 54; // 숫자 최소
        int numberMax = 132; // 숫자 최대
        int numberSum = 0; // 숫자 합
        int numbercount = 0; // 숫자 세기

        while (numbercount < numberMax){ // 숫자가 최대가 될때까지
            numbercount++; // 카운트

            if (numbercount >= numberMin){ // 숫자 최소가 되면
                numberSum += numbercount; // 숫자를 합치기 시작함
            }
            System.out.println(numbercount + " " + numberSum);
        }
        System.out.println("총 합 : " + numberSum);

    }
}
