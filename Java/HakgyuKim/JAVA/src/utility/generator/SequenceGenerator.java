package utility.generator;

public class SequenceGenerator {
    private static int currentmemberId = 0;

    public static int getCurrentSequenceMemberId () {
        return currentmemberId++;
    }
}
