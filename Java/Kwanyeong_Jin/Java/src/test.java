class Teest {
    public int solution(int num1, int num2) {
        return num1/num2 ;
    }
}

class Solution {
    public int solution(int num1, int num2) {
        int answer = 0;
        if (num1 == num2){
            answer = 1;
        } else { answer = -1;}
        return answer;
    }
}

public class test {
    public static void main(String[] args) {
//        // sout == System.out.println --- 2023/03/20
//        System.out.println("안녕 자바!");
//        // 2023/03/21 --- 추가
//        System.out.println("변경 내역 추가");
//        // 2023/03/21 --- 추가
//        System.out.println("새로운 내역 추가");
        Teest test = new Teest();
        System.out.println(test.solution(10,5));
    }
}