package kr.eddi.demo.homeworkSolution.problem5.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {

    private Long gameAccountId;

    public RequestAccountIdForm(Long gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}