package kr.eddi.demo.lectureClass.vue.problem4.controller.entitiy;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Account {

    private Long id;
    private String email;
    private String password;

}
