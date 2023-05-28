package com.example.demo.problem11.service;

import com.example.demo.problem11.service.request.BusinessAccountRegisterRequest;
import com.example.demo.problem11.service.request.NormalAccountRegisterRequest;

public interface AccountService {
    Boolean registerNormalAccount(NormalAccountRegisterRequest request);

    Boolean registerBusinessAccount(BusinessAccountRegisterRequest businessAccountRegisterRequest);
}
