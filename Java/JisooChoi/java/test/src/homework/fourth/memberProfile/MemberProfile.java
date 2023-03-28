package homework.fourth.memberProfile;

public class MemberProfile {
    //필드
    private String nickName;
    private Address address;

    //생성자
    public MemberProfile() {}

    // 1. 처음부터 address를 객체를 따로 만들고 가져오기
    public MemberProfile(String nickName, Address address){
        this.nickName = nickName;
        this.address = address;
    }

    // 2. 생성하면서 address 객체를 만들어 줌
    public MemberProfile(String nickName, String city, String streetName, String detailAdd, String postalAdd){
        this.nickName = nickName;
        this.address = new Address(city, streetName, detailAdd, postalAdd);
    }

    //메서드
    public void showInfo(){
        System.out.println("닉네임: "+nickName);
        System.out.println("도시: "+ address.getCity());
        System.out.println("거리명: "+address.getStreetName());
        System.out.println("세부주소: "+address.getDetailAdd());
        System.out.println("우편번호: "+address.getPostalAdd());
    }
}
