package com.example.examplejwtwebmvc.auth.service;

import com.example.examplejwtwebmvc.auth.controller.dto.SignUpRequestDto;
import com.example.examplejwtwebmvc.auth.domain.Account;
import com.example.examplejwtwebmvc.auth.domain.types.AccountStatus;
import com.example.examplejwtwebmvc.auth.dto.JwtAuthTokens;
import com.example.examplejwtwebmvc.auth.mapper.AccountDtoMapper;
import com.example.examplejwtwebmvc.auth.repository.AccountRepository;
import com.example.examplejwtwebmvc.auth.usecase.SignInUseCase;
import com.example.examplejwtwebmvc.auth.usecase.SignUpUseCase;
import com.example.examplejwtwebmvc.common.support.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Provider;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor // private final AccounRespository 같이 final이나 nonull붙은 필드들에 대한 생성자들이 생긴다.(<- 의존성 주입도 같이 생긴다.)
public class AuthenticationService implements SignUpUseCase, SignInUseCase {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final AccountDtoMapper mapper;

    @Override
    public Account signUp(Account account) {

        account.password = passwordEncoder.encode(account.password);
        return accountRepository.save(account);
    }

    @Override
    public Account signUp(SignUpRequestDto dto) {
        Instant now = Instant.now();

//        Account account = Account.builder().
//                username(dto.username())
//                .password(dto.password())
//                .nickname(dto.nickname())
//                .status(AccountStatus.ACTIVE)
//                .createdAt(now)
//                .updatedAt(now)
//                .build();
        //builder로 시작해서 build로 끝난다.


        Account account = mapper.toEntity(dto, AccountStatus.ACTIVE, Instant.now());
        return signUp(account);
    }

    @Override
    public JwtAuthTokens signIn(String username, String password) {
        Account account = accountRepository
                .findById(username)
                .orElseThrow(()->new RuntimeException("아이디 또는 비밀번호가 없습니다."));

        boolean isMatched = passwordEncoder.matches(password, account.password);

        if(!isMatched){
            throw new RuntimeException("아이디 또는 비밀번호가 없습니다.");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("nickname", account.nickname);
        claims.put("authority", "USER");// 권한 부여 방식이 회사마다 다름

        String accessToken = jwtProvider.generateJwt(username, claims);

        return JwtAuthTokens.builder()
                .accessToken(accessToken)
                .refreshToken(accessToken)
                .build();


    }

}
