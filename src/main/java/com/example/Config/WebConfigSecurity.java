package com.example.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.jwt.AuthTokenFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebConfigSecurity {
    private final AuthenticationProvider authenticationProvider;
    private final AuthTokenFilter authTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(csrf ->
                        csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/test/all").permitAll()
                                .requestMatchers("/api/test/user").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/api/test/admin").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/Course/post").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/Course/put/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/Course/delete/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/v1/Course/get").permitAll()
                                .requestMatchers("/api/v1/experience/get").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/api/v1/experience/put/**").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/api/v1/experience/delete/**").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/api/v1/experience/post").hasAnyAuthority("ADMIN", "USER")
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
}
