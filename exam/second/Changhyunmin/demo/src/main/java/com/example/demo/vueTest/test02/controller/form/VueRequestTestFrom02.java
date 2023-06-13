package com.example.demo.vueTest.test02.controller.form;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
public class VueRequestTestFrom02 {
    private String hello;

    public VueRequestTestFrom02(String hello) {
        this.hello = hello;
    }
}
