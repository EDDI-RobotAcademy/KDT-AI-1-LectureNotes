package homework.third.homework;

/*
회원(Member) 클래스를 만들어서
회원 가입을 진행해봅시다!
회원 이메일 주소와 비밀번호를 입력받습니다.
입력한 이메일 주소와 비밀번호가 올바르게 들어갔는지 확인해봅시다.
 */


//  Meber, Input, Check로 나누고
//  Meber에서 원본
//  Input에서 입력
//  Check에서 확인 하려고 했습니다만 막혔습니다
//  지금 적은 것도 의도한대로 적었는지도 헷갈립니다 ㅠㅠ

//class Member {
//    private String mailPassword = "xx", "xxx";
//
//    public String getMailPassword () {
//        return mailPassword;
//    }
//
//}
//
//class Input{
//    private String inputMailPassword;
//
//    private void setInputMailPassword (String mail, String password) {
//        this.inputMailPassword = mail, password;
//    }
//
//    public String getInputMailPassword () {
//        return inputMailPassword;
//    }
//
//
//}
//
//class Check {
//    private int okCkeck;
//    private Member member;
//    private Input input;
//
//}

class MemberObject {
    final private String email;
    final private String password;

    public MemberObject(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

public class Class2 {
    public static void main(String[] args) {
        MemberObject member = new MemberObject("이메일", "비밀번호")
        System.out.println(member);
    }


}
