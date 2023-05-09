package kr.eddi.demo.memberCode.member.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class TestMember {
    @Id
    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String password;

    public TestMember(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
