package com.gordon.config;

import com.gordon.filter.CsrfCookieFilter;
import com.gordon.filter.JWTTokenGeneratorFilter;
import com.gordon.filter.JWTTokenValidatorFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class ProjectSecurityConfig {

  @Value("${jwt.secretKey}")
  private String jwtSecretKey;

  private static final String[] LIST_AUTHENTICATE = {
      "/user"
  };

  private static final String[] LIST_REQUIRE_ROLE = {
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

  private static final String[] LIST_CSRF_IGNORE = {
      "/contact",
      "/register"
  };

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    /**
     * CSRF
     *  From Spring Security 6, by default the CSRF Cookie that got generated during initial login will not be shared to UI application.
     *  The developer has to write logic to read the CSRF token and send it as part of the response. When framework sees the
     *  CSRF token in the response header, it takes of sending the same as Cookie as well. For the same, I have created
     *  a filter with the name CsrfCookieFilter and configured the same to run every time after the Spring Security in built filter
     *  BasicAuthenticationFilter like shown below. More details about Filters, are discussed inside the Section 8 of the course.
     */
    http.csrf()
        .ignoringRequestMatchers(LIST_CSRF_IGNORE)
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
        .and().addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)

        // security context
        .securityContext()
        .requireExplicitSave(false)
        // jwt uses no session
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilterBefore(new JWTTokenValidatorFilter(jwtSecretKey), BasicAuthenticationFilter.class)
        .addFilterAfter(new JWTTokenGeneratorFilter(jwtSecretKey), BasicAuthenticationFilter.class)

        // cors setting
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

        // authenticate setting
        .and().authorizeHttpRequests()
        .requestMatchers(LIST_REQUIRE_ROLE).hasAnyRole("USER", "ADMIN")
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
