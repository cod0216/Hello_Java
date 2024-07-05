package com.example.examplejwtwebmvc.common.support;

import com.example.examplejwtwebmvc.common.properies.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtProvider {
    private final Key secretKey;
    private final Long maxAge;


    public JwtProvider(JwtProperties jwtProperties) {
        this.secretKey = jwtProperties.secretKey();
        this.maxAge = jwtProperties.maxAge();
    }

    public String generateJwt(String subject, Map<? extends  String, ?> payload){
        Claims claims = Jwts.claims()
                .setSubject(subject);

        //우린 payload 부분에 신경쓸꺼임

        Date now = new Date();
        Date expirationAt = new Date(now.getTime()+maxAge);

        claims.putAll(payload);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(String.valueOf(now))
                .setExpiration(expirationAt)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

}
