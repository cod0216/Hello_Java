package com.example.examplejwtwebmvc.auth.dto;

import lombok.Builder;

@Builder
public record JwtAuthTokens(String accessToken, String refreshToken) {

}
