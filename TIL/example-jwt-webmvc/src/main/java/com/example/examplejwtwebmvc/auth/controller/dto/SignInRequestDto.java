package com.example.examplejwtwebmvc.auth.controller.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

@Builder
public record SignInRequestDto(

        @NotBlank(message = "사용자 이름을 입력하십시오.")
        @Pattern(
                regexp = "^[a-z]+[a-z0-9]{3,15}$",
                message = "사용자 이름은 소문자로 시작하여야 하며, 알파벳 소문자와 숫자만 허용합니다. (3~15자)"
        )
        String username,

        @NotBlank(message = "비밀번호를 입력하십시오.")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,100}$",
                message = "비밀번호는 영문, 숫자, 특수문자를 모두 포함하여 8자리 이상 100자리 이하 ~"
        )
        String password
) {
}
