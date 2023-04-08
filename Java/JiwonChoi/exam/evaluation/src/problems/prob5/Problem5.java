package problems.prob5;

import java.util.ArrayList;

/*
5. 아래와 같은 숫자 나열이 있습니다. 3, 3, 3, 6, 9, 12, 18, 27, 39, 57, …
이 숫자 나열의 20번째엔 어떤 숫자가 있을지 프로그램을 작성해보세요.
*/
public class Problem5 {
    public static void main(String[] args) {

        ArrayList<Integer> numsList = new ArrayList<>();
        numsList.add(3);
        numsList.add(3);
        numsList.add(3);

        int numberth = 20;
        int realInDex = numberth - 1;

        for(int i = 0; i+2 < realInDex; i++){
            int tmpNum = numsList.get(i+2)+ numsList.get(i);
            numsList.add(tmpNum);
        }

        System.out.println(numsList);

    }
}
