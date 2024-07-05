package com.example.examplejwtwebmvc.auth.mapper;

import com.example.examplejwtwebmvc.auth.controller.dto.SignUpRequestDto;
import com.example.examplejwtwebmvc.auth.domain.Account;
import com.example.examplejwtwebmvc.auth.domain.types.AccountStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper
public interface AccountDtoMapper {
    Account toEntity(SignUpRequestDto dto, AccountStatus status, Instant createdAt);
}
