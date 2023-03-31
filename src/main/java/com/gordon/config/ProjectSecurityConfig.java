package com.gordon.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class ProjectSecurityConfig {

  @Value("${jwt.secretKey}")
  private String jwtSecretKey;

  private static final String[] LIST_AUTHENTICATE = {
      "/myAccount",
      "/myBalance",
      "/myLoans",
      "/myCards"
  };

  private static final String[] LIST_PERMIT_ALL = {
      "/notices",
      "/contact",
      "/register"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable()

        .cors()
        .configurationSource(request -> {
          CorsConfiguration config = new CorsConfiguration();
          config.setAllowedOrigins(List.of("http://localhost:4200"));
          config.setAllowedMethods(List.of("*"));
          config.setAllowCredentials(true);
          config.setAllowedHeaders(List.of("*"));
          config.setMaxAge(3600L);
          config.setExposedHeaders(List.of("Authorization"));
          return config;
        })

        .and().authorizeHttpRequests()
        .requestMatchers(LIST_AUTHENTICATE).authenticated()
        .requestMatchers(LIST_PERMIT_ALL).permitAll()
        .and().httpBasic()
        .and().formLogin();
    return http.build();
  }

  @Bean
  public PasswordEncoder bcryptEncoder() {
    return new BCryptPasswordEncoder();
  }

}
