package com.example.demo.lectureClass.testCode.order.controller.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TestOrderListRequestForm {
    final private String userToken;
    /*
        유저토큰만 필요
        이미 회원 등록하고 로그인하는 메서드는 실행되고 있음
        그래서 그 정보로 해당 회원이 주문한 상품 리스트만 보면 되기에 userToken만 있으면 되는 것 같음
        상품 아이디는 오더 리퀘스트 폼에 있음
        상품 주문할 때 상품아이디 가지고 입력했으니까
        더 이상 상품을 불러올 필요 없고
        그 회원의 토큰을 불러와서 확인만 하면 되는 것 같음
     */
}
