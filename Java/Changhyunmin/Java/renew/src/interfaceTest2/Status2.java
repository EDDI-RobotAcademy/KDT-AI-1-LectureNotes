package interfaceTest2;

public enum Status2 {
    NORMAL("정상",1),
    DEATH("죽음",-777);
    final private String statusName;
    final private int value;

    Status2(String statusName, int value) {
        this.statusName = statusName;
        this.value = value;
    }

    public String getStatusName() {
        return statusName;
    }

    public int getValue() {
        return value;
    }
}
