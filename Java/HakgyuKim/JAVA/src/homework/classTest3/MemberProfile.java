package homework.classTest3;

public class MemberProfile {

    final private String memberNickname;
    final private String memberAddressCity;
    final private String memberAddressStreet;
    final private String memberAddressDetail;
    final private String memberAddressPostnumber;

    public MemberProfile(String memberNickname,
                         String memberAddressCity,
                         String memberAddressStreet,
                         String memberAddressDetail,
                         String memberAddressPostnumber) {
        this.memberNickname = memberNickname;
        this.memberAddressCity = memberAddressCity;
        this.memberAddressStreet = memberAddressStreet;
        this.memberAddressDetail = memberAddressDetail;
        this.memberAddressPostnumber = memberAddressPostnumber;
    }

    @Override
    public String toString() {
        return "MemberProfile{" +
                "memberNickname='" + memberNickname + '\'' +
                ", memberAddressCity='" + memberAddressCity + '\'' +
                ", memberAddressStreet='" + memberAddressStreet + '\'' +
                ", memberAddressDetail='" + memberAddressDetail + '\'' +
                ", memberAddressPostnumber='" + memberAddressPostnumber + '\'' +
                '}';
    }
}
