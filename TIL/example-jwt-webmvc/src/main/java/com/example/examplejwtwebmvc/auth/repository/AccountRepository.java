package com.example.examplejwtwebmvc.auth.repository;

import com.example.examplejwtwebmvc.auth.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface AccountRepository extends JpaRepository<Account, String> {
    //단건조회 via 닉네임
//    Optional<Account> findByNickname(String nickname);

//    List<Account> findByStatus(String nickname);

    //
}
