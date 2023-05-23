package kr.eddi.demo.lectureClass.testCode.problem.member.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public MemberRole(String role, Member member) {
        this.role = role;
        this.member = member;
    }
}
