package kr.eddi.demo.lectureClass.vue.problem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DownloadImage {
    private String downloadImagePath;
    public String downloadImage () {
       return "mario_run.png";
    }
}
