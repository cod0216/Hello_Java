package com.example.examplejwtwebmvc.auth.controller;

import com.example.examplejwtwebmvc.auth.controller.dto.SignInRequestDto;
import com.example.examplejwtwebmvc.auth.controller.dto.SignInResponseDto;
import com.example.examplejwtwebmvc.auth.controller.dto.SignUpRequestDto;
import com.example.examplejwtwebmvc.auth.controller.dto.SignUpResponseDto;
import com.example.examplejwtwebmvc.auth.dto.JwtAuthTokens;
import com.example.examplejwtwebmvc.auth.usecase.SignInUseCase;
import com.example.examplejwtwebmvc.auth.usecase.SignUpUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.boot.autoconfigure.security.oauth2.server.servlet.OAuth2AuthorizationServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequiredArgsConstructor
public class AuthApi {

    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpRequestDto body){

        signUpUseCase.signUp(body);

        return SignUpResponseDto.builder()
                .success(true)
                .build();

    }

    @PostMapping("/sign-in")
    public SignInResponseDto signIn(@RequestBody @Valid SignInRequestDto body){
        JwtAuthTokens tokens = signInUseCase.signIn(body.username(), body.password());

        return SignInResponseDto.builder()
        .accessToken(tokens.accessToken())
        .build();
    }


}
