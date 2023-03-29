package homework.homework1.refacktor;

public class randomNumber {

    public static int randomNumber(int MAX, int MIN) {
        return (int)((Math.random() * MAX -MIN + 1) +MIN);
    }

}
