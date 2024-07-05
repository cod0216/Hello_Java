package com.example.examplejwtwebmvc.auth.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SignInResponseDto(
        @JsonProperty("access_token")
        @JsonInclude(JsonInclude.Include.NON_EMPTY) // null, ""일 땐 ...
        String accessToken
){}
