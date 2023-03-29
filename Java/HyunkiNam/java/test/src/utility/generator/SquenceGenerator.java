package utility.generator;

public class SquenceGenerator {
    private static int memberId = 0;

    public static int getCurrentSequenceMemberId(){
        return memberId++;
    }
}
