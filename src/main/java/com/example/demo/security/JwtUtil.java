package com.example.demo.security;

import com.example.demo.Model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJPbmxpbmUgSldU" +
            "IEJ1aWxkZXIiLCJpYXQiOjE3Mzg5MTQyOTksImV4cCI6MTc3MDQ1MDI5OSwiYXVkIjoid3d3L" +
            "mV4YW1wbGUuY29tIiwic3ViIjoianJvY2tldEBleGFtcGxlLmNvbSIsIkdpdmVuTmFtZSI6Ikp" +
            "vaG5ueSIsIlN1cm5hbWUiOiJSb2NrZXQiLCJFbWFpbCI6Impyb2NrZXRAZXhhbXBsZS5jb20iLCJSb2" +
            "xlIjpbIk1hbmFnZXIiLCJQcm9qZWN0IEFkbWluaXN0cmF0b3IiXX0.nRMwAETuzL8zHK7lV-bCzgsdx30fzUX-6WlmzctCy1c";

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .compact();

    }

    public boolean validateToken(String token, String username) {
        return getUsernameFromToken(token).equals(username) && !isTokenExpired(token);

    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody().getSubject();
    }

    private boolean isTokenExpired(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getExpiration().before(new Date());
    }


    public boolean validateToken(String token, User user) {
        try {
            String username = getUsernameFromToken(token);
            return username.equals(user.getUsername()) && !isTokenExpired(token);
        } catch (JwtException | IllegalArgumentException e) {
            return false; // Invalid token
        }
    }

}
