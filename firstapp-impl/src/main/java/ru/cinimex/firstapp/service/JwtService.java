package ru.cinimex.firstapp.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@RequiredArgsConstructor
@Component
public class JwtService {

    @Value("${jwt.secret}")
    private final String jwtSecret;

    public String generateToken(Authentication authenticate) {

        if (authenticate.getPrincipal() instanceof User user) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());

            return Jwts.builder()
                    .claims(claims)
                    .subject(user.getUsername())
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3))
                    .signWith(getSignKey(), Jwts.SIG.HS256).compact();
        }
        throw new IllegalArgumentException("Incorrect type of authentication principal");
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateTechToken(OffsetDateTime expiredDate) {
        final Map<String, Object> claims = new HashMap<>();
        claims.put("roles", List.of("TECH"));
        return Jwts.builder()
                .claims(claims)
                .subject("tech_user")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(Date.from(expiredDate.toInstant()))
                .signWith(getSignKey(), Jwts.SIG.HS256).compact();
    }

    public List<String> extractRole(String token) {
        return extractClaim(token,
                claims -> claims.get("roles", List.class));
    }
}
