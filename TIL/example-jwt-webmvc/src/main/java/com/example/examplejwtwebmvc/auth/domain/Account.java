package com.example.examplejwtwebmvc.auth.domain;

import com.example.examplejwtwebmvc.auth.domain.types.AccountStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    public String username;
    public String password;
    public String nickname;

    //보통 public 이 아닌 private를 사용한다
    // 그리고 setter를 안만든다. -> 변경하고 싶을때 update 메서드를 따로 만든다.


    @Enumerated(EnumType.STRING)
    public AccountStatus status;
    public Instant createdAt;
    public Instant updatedAt;
}
