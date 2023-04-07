package customLibrary;

public class CustomRandom {
    public static int generateNumber(int min, int max){
        return (int)(Math.random() * (max-min+1)) + min;
    }
    public static int generateNumber(int max){
        return generateNumber(0,max);
    }
}
