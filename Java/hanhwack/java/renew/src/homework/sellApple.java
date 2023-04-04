package homework;

class Random {
    final private int MIN  = 5000 ;
    final private int MAX = 10000 ;
    int randomNum ;


    public int getRandom (int min, int max) {
      return (int) (Math.random() * (max - min + 1)) + min;

    }


}

public class sellApple {
    public static void main(String[] args) {

        int countApple ;
        int applePrice ;
        Random random = new Random();
        countApple = random.getRandom(3, 5) ;
        applePrice = random.getRandom(5000, 10000) ;

        System.out.println("사과의 가격은 " + applePrice +"원");
        System.out.println("수확한 사과의 갯수는 " + countApple + "개");
        System.out.println("사과 매출은 " + (applePrice * countApple) +"원");



    }


}
