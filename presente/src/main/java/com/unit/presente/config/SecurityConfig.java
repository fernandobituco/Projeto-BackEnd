package com.unit.presente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] SWAGGER_WHITELIST = {
            "/v2/api-docs",
            "/v3/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/h2-console/**",
            "/**"
    };
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(CsrfConfigurer::disable)
        .authorizeHttpRequests((requests) -> requests
            .requestMatchers(SWAGGER_WHITELIST).permitAll()
            .anyRequest().anonymous()
        );
        // .formLogin((form) -> form
        //     .loginPage("/login")
        //     .permitAll()
        // )
        // .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
