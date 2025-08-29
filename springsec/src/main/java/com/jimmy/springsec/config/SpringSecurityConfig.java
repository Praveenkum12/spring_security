package com.jimmy.springsec.config;

import com.jimmy.springsec.security.BankAccessDeniedHandler;
import com.jimmy.springsec.security.BankAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.password.HaveIBeenPwnedRestApiPasswordChecker;

@Configuration
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request->
                request
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/welcome").authenticated()
                        )
                .httpBasic(hbc -> hbc.authenticationEntryPoint(new BankAuthenticationEntryPoint()))
                .formLogin(flc -> flc.disable())
                .exceptionHandling(ehc -> ehc.accessDeniedHandler(new BankAccessDeniedHandler()));

        return http.build();
    }

    @Bean
    public CompromisedPasswordChecker compromisedPasswordChecker() {
        return new HaveIBeenPwnedRestApiPasswordChecker();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
