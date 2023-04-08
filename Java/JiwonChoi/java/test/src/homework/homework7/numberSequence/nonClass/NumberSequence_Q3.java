package homework.homework7.numberSequence.nonClass;

import java.util.ArrayList;

public class NumberSequence_Q3 {

    public static void main(String[] args) {
        ArrayList <Integer> NumberList = new ArrayList<>();

        for(int i = 1; i < 101; i++){
            if(i % 4 == 0) {
                NumberList.add(i);
            }
        }

        int sumNumber_Q4 = 0;

        for(int i = 0; i < NumberList.size(); i++){
            sumNumber_Q4 += NumberList.get(i);
        }

        System.out.println(sumNumber_Q4);

    }

}
