package homework;

public class Test1 {
    public static void main(String[] args) {

        final int MAX = 6;
        final int MIN = 1;

        final int randomDice1 = (int)(Math.random() * MAX) +MIN;
        final int randomDice2 = (int)(Math.random() * MAX) +MIN;

        int sum = 0;
        sum = randomDice1 + randomDice2;

        int res = (sum % 4);
        if(res == 0){
            System.out.println("결과 : "+sum);
            System.out.println("첫 번째 주사위 값: "+randomDice1+", 두 번째 주사위 값: "+randomDice2+" => 성공 !");
        }
        else {
            System.out.println("결과 : "+sum);
            System.out.println("첫 번째 주사위 값: "+randomDice1+", 두 번째 주사위 값: "+randomDice2+" => 실패 !");
        }
    }
}
