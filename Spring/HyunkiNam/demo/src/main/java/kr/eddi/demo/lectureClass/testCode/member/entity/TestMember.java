package kr.eddi.demo.lectureClass.testCode.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class TestMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Getter
    private String memberName;
    @Getter
    private String memberPassword;

    public TestMember(String memberName, String memberPassword) {
        this.memberName = memberName;
        this.memberPassword = memberPassword;
    }
}
