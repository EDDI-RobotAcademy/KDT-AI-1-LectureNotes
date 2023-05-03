package com.example.demo.lectureClass.vue.problem.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.bind.annotation.RestController;

@Getter
@ToString
@NoArgsConstructor
public class RequestAccountIdForm {
    private Long gameAccountId;

    public RequestAccountIdForm(Long gameAccountId) {
        this.gameAccountId = gameAccountId;
    }
}
