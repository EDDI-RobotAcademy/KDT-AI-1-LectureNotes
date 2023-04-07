package test2;

import java.util.ArrayList;
import java.util.List;

public class Bread{

    public static void main(String[] args){
        List<Bread> bag = new ArrayList<>();
        for (int i =0 ; i<30 ;i++){
            Bread bread = new Bread();
            bag.add(bread);
        }
        System.out.println(bag);
    }
}
