package com.spring.todo.sercurity.jwt;

import com.spring.todo.model.entities.AccountEntity;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class TokenProvider {
    private final Key key;
    private final JwtParser jwtParser;
    private final String JWT_SECRET = "myi32icharacteriultraisecureiandiultrailongisecret";
    private final long JWT_EXPIRATION = 604800000L;
    private static final String AUTHORITIES_KEY = "auth";

    public TokenProvider() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
        jwtParser = Jwts.parser().setSigningKey(JWT_SECRET);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(AccountEntity accountEntity, List<String> listAuthority) {
        String authorities = String.join(",", listAuthority);
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        return Jwts.builder().setSubject(accountEntity.getId())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        List<? extends GrantedAuthority> authorities = Arrays
                .stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .filter(auth -> !auth.trim().isEmpty())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);
        /**
         * claims.getSubject() lay thong tin duoc gan vao token
         * password
         * authorities danh sach cac quyen
         */

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public String getAccountIdFromJwt(String token) {
        Claims claims = jwtParser.
                parseClaimsJws(token).
                getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            jwtParser.parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
