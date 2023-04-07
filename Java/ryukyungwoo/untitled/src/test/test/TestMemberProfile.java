package test.test;

class MemberProfile {
    final private String memberName;
    final private String livngTown;
    final private String address;
    final private String postNumber;

    public MemberProfile(String memberName, String livngTown, String address, String postNumber) {
        this.memberName = memberName;
        this.livngTown = livngTown;
        this.address = address;
        this.postNumber = postNumber;
    }

    @Override
    public String toString() {
        return "MemberProfile{" +
                "memberName='" + memberName + '\'' +
                ", livngTown='" + livngTown + '\'' +
                ", address='" + address + '\'' +
                ", postNumber='" + postNumber + '\'' +
                '}';
    }
}

public class TestMemberProfile {
    public static void main(String[] args) {
        MemberProfile memberProfile = new MemberProfile ("유경우", "관악구", "307호", "1234");
        System.out.println(memberProfile);
    }
}