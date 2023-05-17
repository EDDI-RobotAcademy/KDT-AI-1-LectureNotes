package kr.eddi.demo.refactorAccount.service;

import kr.eddi.demo.refactorAccount.service.request.RefactorAccountRegisterRequest;

public interface RefactorAccountService {
        Boolean register(RefactorAccountRegisterRequest request);
    }

