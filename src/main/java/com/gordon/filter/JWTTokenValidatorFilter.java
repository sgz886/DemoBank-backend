package com.gordon.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.crypto.SecretKey;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTTokenValidatorFilter extends OncePerRequestFilter {

  private final String jwtSecretKey;

  public JWTTokenValidatorFilter(String jwtSecretKey) {
    this.jwtSecretKey = jwtSecretKey;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String jwt = request.getHeader(HttpHeaders.AUTHORIZATION);
    if (jwt != null) {
      try {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
        Claims claimBody = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(jwt)
            .getBody();
        String username = String.valueOf(claimBody.get("username"));
        String authorities = String.valueOf(claimBody.get("authorities"));
        Authentication auth = new UsernamePasswordAuthenticationToken(
            username, null,
            AuthorityUtils.commaSeparatedStringToAuthorityList(authorities)
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
      } catch (Exception e) {
        throw new BadCredentialsException("Invalid Token received!");
      }
    }
    filterChain.doFilter(request, response);
  }

  /**
   * when login successful, endpoint redirects to /user
   * there is no need to validate jwt then,
   * other times, validation is necessary
   * @param request current HTTP request
   * @return
   * @throws ServletException
   */
  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
    return request.getServletPath().equals("/user");
  }
}
