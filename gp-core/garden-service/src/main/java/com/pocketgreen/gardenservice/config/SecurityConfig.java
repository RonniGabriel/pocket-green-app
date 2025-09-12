package com.pocketgreen.gardenservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain security (HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(csrf->csrf
                        .ignoringRequestMatchers("/swagger-ui/**","/v3/api-docs/**","h2-console/**").disable())
                .headers(header-> header.frameOptions(
                        frame -> frame.sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs.yaml", "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )
                .httpBasic(b -> {});
        return httpSecurity.build();
    }
}