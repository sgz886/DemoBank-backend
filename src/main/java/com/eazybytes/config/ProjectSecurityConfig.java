package com.eazybytes.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

  @Bean
  public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
        .requestMatchers("/notices", "/contact","/register","/test").permitAll()
        .and().httpBasic()
        .and().formLogin();
    return http.build();
  }

  /*
   * 默认的JdbcUserDetailsManager, 需要注册为bean才能使用
   * @param dataSource 默认的数据源
   * @return JdbcUserDetailsManager实例
   */
  // @Bean
  // public UserDetailsService userDetailsService(DataSource dataSource) {
  //   return new JdbcUserDetailsManager(dataSource);
  // }



  /**
   * NoOpPasswordEncoder is not recommended for production usage
   * @return PasswordEncoder
   */
  @Bean
  public PasswordEncoder noEncoder(){
    return NoOpPasswordEncoder.getInstance();
  }
}
