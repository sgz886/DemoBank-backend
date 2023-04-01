package com.gordon.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

  private static final long HOUR = 3600 * 1000;

  @Value("${jwt.secretKey}")
  private String jwtSecretKey;

  public JWTTokenGeneratorFilter(String jwtSecretKey) {
    this.jwtSecretKey = jwtSecretKey;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null) {
      SecretKey key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
      String jwt = Jwts.builder()
          .claim("username", authentication.getName())
          .claim("authorities", populateAuthorities(authentication.getAuthorities()))
          .setIssuedAt(new Date())
          .setExpiration(new Date(System.currentTimeMillis() + 24 * HOUR))
          .signWith(key).compact();
      response.setHeader(HttpHeaders.AUTHORIZATION, jwt);
    }
    filterChain.doFilter(request, response);
  }

  private String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
    return authorities.stream()
        .map(GrantedAuthority::getAuthority)
        .collect(Collectors.joining(","));
  }

  /**
   * when login successful, endpoint redirects to /user
   * at this time, doFilterInternal needs to be invocated.
   * In any other endpoints, doFilterInternal don't run, needs to be skipped
   * @param request current HTTP request
   * @return
   * @throws ServletException
   */
  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return !request.getServletPath().equals("/user");
  }
}
