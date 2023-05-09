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
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Getter
    private String name;

    public TestMember(String id) {
        this.id = id;
    }
}
