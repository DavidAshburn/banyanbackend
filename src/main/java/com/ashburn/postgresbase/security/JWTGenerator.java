package com.ashburn.postgresbase.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JWTGenerator {
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + SecurityConstants.JWT_LIFESPAN);
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_SECRET.getBytes());

        String jwts = Jwts.builder()
                .subject(username)
                .issuedAt(currentDate)
                .expiration(expireDate)
                .signWith(key)
                .compact();

        return jwts;
    }

    public String getUserNameFromJWT(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_SECRET.getBytes());

        Claims claims = Jwts.parser()
                .verifyWith(key).build().parseSignedClaims(token).getPayload();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_SECRET.getBytes());

        try {
            Jwts.parser()
                    .verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or invalid");
        }
    }
}
