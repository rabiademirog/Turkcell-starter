package com.turkcell.spring.starter.util.jwt;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService
{
    @Value("${jwt.expiration}")
    private Long EXPIRATION_TIME;
    @Value("${jwt.secret}")
    private String SECRET_KEY;


    public String generateToken(String username) {
        Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis()))
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME ))
                .signWith(getSignKey())
                .compact();
        return "";
    }

    public boolean verifyToken(String token)
    {
        // Claim => Jwt'deki her bir özellik.
        Claims claims = Jwts
                .parser()
                .verifyWith((SecretKey) getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        //Eğer ilgili secret key ile doğrulanırsa, jwt içindeki bilgileri verir.
        return claims.getExpiration().after(new Date());
    }

    public String extractUsername(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith((SecretKey) getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    //Boilerplate Code
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
