package com.example.examplejwtwebmvc.auth.usecase;

import com.example.examplejwtwebmvc.auth.dto.JwtAuthTokens;

public interface SignInUseCase {
    JwtAuthTokens signIn(String username, String password);
}
