package com.example.examplejwtwebmvc.common.properies;


import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;

import java.security.Key;

@ConfigurationProperties("app.jwt")
@ConfigurationPropertiesBinding
public record JwtProperties(
        String secret,
        Long maxAge
) {
    public JwtProperties {
        if (maxAge == null) {
            maxAge = 1_800L;
        }
    }

    public Key secretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

