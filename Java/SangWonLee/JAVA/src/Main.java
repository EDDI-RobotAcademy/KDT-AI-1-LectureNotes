import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        // psvm = main 자동생성
        // sout =  System.out.println 자동생성
        System.out.println("안녕 자바 !");

        // 2023/03/21 추가
        System.out.println("변경 내용 추가");

        // 2023/03/21 변경 사항
        System.out.println("하하호호 오늘도 즐거운 하루");
        System.out.println("하하호호 오늘도 즐거운 하루");
        System.out.println("하하호호 오늘도 즐거운 하루");

        int[] abc = {1,2,3,4,5};

        System.out.println(abc);
        System.out.println(abc[1]);

        ArrayList<String> abcd = new ArrayList<>();

        abcd.add("베베");
        abcd.add("보보");
        abcd.add("부부");
        abcd.add("방방");

        abcd.add(1,"뽕뽕");
        abcd.set(3,"삐삐");
        abcd.remove(4);
        System.out.println(abcd.size());

        System.out.println(abcd);
        System.out.println(abcd.get(2) + abcd.get(3));

        List<String> abcdList = new ArrayList<>();
        
        abcdList.add("고고");
        abcdList.add("구구");
        abcdList.add("광광");
        abcdList.add("키키");

        abcdList.add(1,"꺅꺅");

        System.out.println(abcdList); // [고고, 꺅꺅, 구구, 광광, 키키]

        abcdList.set(3,"끼끼");
        abcdList.remove(4);
        System.out.println(abcdList.size());

        System.out.println(abcdList);
        System.out.println(abcdList.get(2) + abcdList.get(3));

        System.out.println(abcdList);
        
        









    }
}





