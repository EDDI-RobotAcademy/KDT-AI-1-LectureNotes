package com.example.demo.lectureClass.homework.basic1;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class Hello {
    private String hello;

    public Hello(String hello) {
        this.hello = hello;
    }
}
