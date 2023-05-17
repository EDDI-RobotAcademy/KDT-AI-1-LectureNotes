package kr.eddi.demo.lectureClass.vue.problem4.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Member {

    final private Long memberId;
    final private String uniqueId;
    final private String uniquePw;


}
