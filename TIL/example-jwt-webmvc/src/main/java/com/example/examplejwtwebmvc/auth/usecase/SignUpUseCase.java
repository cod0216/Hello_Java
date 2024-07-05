package com.example.examplejwtwebmvc.auth.usecase;

import com.example.examplejwtwebmvc.auth.controller.dto.SignUpRequestDto;
import com.example.examplejwtwebmvc.auth.domain.Account;

public interface SignUpUseCase {
    Account signUp(Account Account);
    Account signUp(SignUpRequestDto dto);
}
