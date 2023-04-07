package homework8.member;

import java.util.HashMap;
import java.util.Map;

public class Member {
    final private int memberId;
    final private MemberInfo memberInfo;
    final static Map<Integer, MemberInfo> memberMap = new HashMap<>();

    class MemberInfo {
        final private String email;
        final private String password;

        MemberInfo(String email, String password) {
            this.email = email;
            this.password = password;
        }
        String getEmail() {
            return email;
        }
        String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "MemberInfo{" +
                    "email='" + email + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    public Member(int memberId, String email, String password) {
        this.memberId = memberId;
        this.memberInfo = new MemberInfo(email, password);
        memberMap.put(memberId, memberInfo);
    }

    public int getMemberId() {
        return memberId;
    }

    public static MemberInfo getMemberInfo(int memberId) {
        return memberMap.get(memberId);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberInfo=" + memberInfo +
                '}';
    }
}