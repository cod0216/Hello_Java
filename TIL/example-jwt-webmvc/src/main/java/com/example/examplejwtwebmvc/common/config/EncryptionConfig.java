package com.example.examplejwtwebmvc.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class EncryptionConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder(12){


                @Override
                public String encode(CharSequence rawPassword) {
                    return "{bcrypt}"+ super.encode(rawPassword);
                }


                @Override
                public boolean matches(CharSequence rawPassword, String encodedPassword) {
                    encodedPassword = encodedPassword.substring(8);
                    return super.matches(rawPassword, encodedPassword);
                }


                @Override
                public boolean upgradeEncoding(String encodedPassword) {
                    return super.upgradeEncoding(encodedPassword);
                }
            };


    }
}
