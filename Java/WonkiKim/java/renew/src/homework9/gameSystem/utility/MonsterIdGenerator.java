package homework9.gameSystem.utility;

public class MonsterIdGenerator {
    private static int lastMonsterId = 0;

    public static int generateId() {
        return lastMonsterId++;
    }
}
