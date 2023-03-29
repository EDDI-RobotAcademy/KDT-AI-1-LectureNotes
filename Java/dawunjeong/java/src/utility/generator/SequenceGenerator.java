package utility.generator;

public class SequenceGenerator {

    private static int currentMemberId = 0;

    public static int getCurrentSequenceMemberId () {
        return currentMemberId++;
    }
}