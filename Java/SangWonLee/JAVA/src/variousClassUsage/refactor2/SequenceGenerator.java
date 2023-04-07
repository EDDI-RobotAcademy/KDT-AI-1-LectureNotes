package variousClassUsage.refactor2;

public class SequenceGenerator {

    private static int currentMemberId = 0;

    public static int getCurrentSequenceMemberId() {
        return currentMemberId++;
    }
}
