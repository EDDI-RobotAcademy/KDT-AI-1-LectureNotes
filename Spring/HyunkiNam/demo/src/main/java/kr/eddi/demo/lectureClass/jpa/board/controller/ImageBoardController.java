package kr.eddi.demo.lectureClass.jpa.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageBoardController {

    @GetMapping("/get")
    public String getImage(){
        return "crong.jpg";
    }
}
