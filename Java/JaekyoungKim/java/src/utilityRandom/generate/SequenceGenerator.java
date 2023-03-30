package utilityRandom.generate;

public class SequenceGenerator {
        private static int currentMemberID=0;

    public static int getCurrentMemberID() {
        return currentMemberID++;
    }
}
