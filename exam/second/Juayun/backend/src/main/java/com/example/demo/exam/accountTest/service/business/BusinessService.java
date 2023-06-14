package com.example.demo.exam.accountTest.service.business;

import com.example.demo.exam.accountTest.controller.request.business.BusinessLoginRequest;
import com.example.demo.exam.accountTest.controller.request.business.BusinessRegisterRequest;

public interface BusinessService {
    Boolean register(BusinessRegisterRequest toBusinessRegisterRequest);

    String login(BusinessLoginRequest toBusinessLoginRequest);
}
