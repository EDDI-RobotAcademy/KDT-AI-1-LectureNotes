package zproblem.utility;

public class Random {
    public static int generateNumber(int min, int max){
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
