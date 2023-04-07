package homework.fifth.refactor;

public class HomeworkMember {
    final private int memberID;
    final private String email;
    final private String password;

    public HomeworkMember(int memberID, String email, String password){
        this.memberID = memberID;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestMember{" +
                "memberID=" + memberID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
