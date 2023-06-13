package maptest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test {
    ArrayList<String>list = new ArrayList<String>(Arrays.asList("a","b","c","f"));
    Stream stream = list.stream();
    String[] array = new String[]{"a","b","c","f"};
    Stream<String> stream1 = Arrays.stream(array);

    IntStream intStream = IntStream.range(1,11);
    LongStream longStream = LongStream.range(1,100);


    public static void main(String[] args) {
        ArrayList<String>arrList = new ArrayList<String>(Arrays.asList("a","b","c","f"));
        Iterator<String> iter = arrList.iterator();
        while (iter.hasNext()){
//            String str = iter.next();
//            System.out.println("iter값 : "+ str);

            ArrayList<String>list = new ArrayList<String>(Arrays.asList("a","b","c","f"));
            list.stream()
                    .filter("f"::equals)
                    .forEach(System.out::println);
        }

    }



}
