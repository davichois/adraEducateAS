package com.adra.educate.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/api/adra-educate/auth")){
            filterChain.doFilter(request, response);
        } else{
          String authorizationHeader = request.getHeader(AUTHORIZATION);
          if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
              try {
                  String token = authorizationHeader.substring("Bearer ".length());
                  Algorithm algorithm = Algorithm.HMAC256("adra".getBytes());
                  JWTVerifier verifier = JWT.require(algorithm).build();
                  DecodedJWT decodedJWT = verifier.verify(token);
                  String usuCredencial = decodedJWT.getSubject();
                  String[] rols = decodedJWT.getClaim("rols").asArray(String.class);
                  Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                  stream(rols).forEach(rol -> {
                      authorities.add(new SimpleGrantedAuthority(rol));
                  });
                  UsernamePasswordAuthenticationToken authenticationToken =
                          new UsernamePasswordAuthenticationToken(usuCredencial, null, authorities );
                  SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                  filterChain.doFilter(request, response);

              } catch (Exception e){
                  log.error("Error auth con: {}", e.getMessage());
                  response.setHeader("error", e.getMessage());
                  response.setStatus(HttpStatus.FORBIDDEN.value());
                  // response.sendError(HttpStatus.FORBIDDEN.value());
                  Map<String, String> error = new HashMap<>();
                  error.put("error_message", e.getMessage());
                  response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                  new ObjectMapper().writeValue(response.getOutputStream(), error);
              }

          } else{
              filterChain.doFilter(request, response);
          }
        }
    }
}
