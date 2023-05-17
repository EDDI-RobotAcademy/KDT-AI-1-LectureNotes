package kr.eddi.demo.lectureClass.testCode.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class TestMember {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Getter
    String memberName;

    public TestMember (String memberName) {
        this.memberName = memberName;
    }

}
