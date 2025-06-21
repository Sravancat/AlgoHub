package com.algohub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())  // 🔥 Enable CORS
            .csrf(csrf -> csrf.disable())     // 🔒 Disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/code/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
