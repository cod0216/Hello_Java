package com.example.examplejwtwebmvc.auth.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record SignUpResponseDto(

        @JsonInclude(JsonInclude.Include.NON_DEFAULT)
        Boolean success // 응답 안 해줘도 되긴 함. (과거의 습관 같은)
){
}
