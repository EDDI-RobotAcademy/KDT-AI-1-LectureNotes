package customLibrary;

public class Random {

    public static int randomNumber(int min_num, int max_num) {
        int randomNum = (int) ((Math.random()) * (max_num - min_num + 1))+ min_num;
        return randomNum;
    }

    public static int randomNumber(int max_num) {
        int min_num = 0;
        int randomNum = (int) ((Math.random()) * (max_num - min_num + 1)) + min_num;
        return randomNum;
    }

    public static char randomAlphabetSmall() {
        int min_num = 97;
        int max_num = 122;
        int randomNum = (int) ((Math.random()) * (max_num - min_num + 1)) + min_num;
        char randomCharacter = (char)randomNum;
        return randomCharacter;
    }
}
