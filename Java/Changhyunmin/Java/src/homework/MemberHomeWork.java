package homework;

import homework.Member.MEMBER;

public class MemberHomeWork {
    public static void main(String[] args) {
        MEMBER member = new MEMBER();
        member.inputEmail();
        member.inputPassword();
        System.out.println(member);
    }

}
