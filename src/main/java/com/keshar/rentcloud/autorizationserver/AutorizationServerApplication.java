package com.keshar.rentcloud.autorizationserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@SpringBootApplication
@EnableAuthorizationServer
public class AutorizationServerApplication {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(AutorizationServerApplication.class, args);

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println("keshar>>> "+new BCryptPasswordEncoder().encode("keshar"));
        return new BCryptPasswordEncoder();
    }


}
