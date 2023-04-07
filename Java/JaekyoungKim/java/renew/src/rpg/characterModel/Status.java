package rpg.characterModel;

public enum Status {
    NORMAL("정상",1),
    DEATH("죽음",-777);
    final private String statusNamem;
    final private int value;

    Status(String statusNamem, int value) {
        this.statusNamem = statusNamem;
        this.value = value;
    }

    public String getStatusNamem() {
        return statusNamem;
    }

    public int getValue() {
        return value;
    }
}
