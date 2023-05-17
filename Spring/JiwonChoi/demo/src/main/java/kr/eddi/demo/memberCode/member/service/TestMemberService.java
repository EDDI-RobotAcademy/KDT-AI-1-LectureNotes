package kr.eddi.demo.memberCode.member.service;

import kr.eddi.demo.memberCode.member.entity.TestMember;

public interface TestMemberService {
    TestMember register (String id, String name, String password);
}
