package test.test;

class Friend {
    final private String friendName;
    final private int friendPhoneNumber;

    public Friend(String friendName, int friendPhoneNumber) {
        this.friendName = friendName;
        this.friendPhoneNumber = friendPhoneNumber;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "friendName='" + friendName + '\'' +
                ", friendPhoneNumber=" + friendPhoneNumber +
                '}';
    }
}
public class TestPhoneCallTable {
    public static void main(String[] args) {
        Friend friend = new Friend("유경우", 123123);
        System.out.println(friend);
    }
}