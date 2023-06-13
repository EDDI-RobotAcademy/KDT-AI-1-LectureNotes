package kr.eddi.demo.lectureClass.vue.problem.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {

    private int gameAccountId;

    public RequestAccountIdForm(int gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}