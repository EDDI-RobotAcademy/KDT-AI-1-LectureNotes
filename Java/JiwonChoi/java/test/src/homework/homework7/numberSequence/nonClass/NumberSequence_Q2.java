package homework.homework7.numberSequence.nonClass;

import java.util.ArrayList;

public class NumberSequence_Q2 {

    public static void main(String[] args) {
        ArrayList <Integer> NumberList = new ArrayList<>();

        for(int i = 1; i < 101; i++){
            if(i % 3 == 0) {
                NumberList.add(i);
            }
        }

        for(int i = 0; i < NumberList.size(); i++){
            System.out.println(NumberList.get(i));
        }

    }

//    ArrayList <Integer> NumberList = new ArrayList<>();


}
