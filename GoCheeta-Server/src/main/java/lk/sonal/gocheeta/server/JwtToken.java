/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.sonal.gocheeta.server;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.Claims;

/**
 *
 * @author sonal
 */
public class JwtToken {
    
    static JwtToken jwtToken = new JwtToken();
    
    public static JwtToken getInstance(){
        return jwtToken;
    }
    // GoCheetaSecret
    static String secret = "fb52c1326ccd582782fdd8452a995183bc4c7bee311d5ba7ff52f95ea336ce92";
    
    public static String createJWT(String userID, String BranchID, String AccountType) {
  
        

        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                                    SignatureAlgorithm.HS256.getJcaName());

        Instant now = Instant.now();
        String jwtToken = Jwts.builder()
                .claim("UserId", userID)
                .claim("BranchID", BranchID)
                .claim("AccountType", AccountType)
                .setSubject("jane")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(5l, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();

        //Builds the JWT and serializes it to a compact, URL-safe string
        return jwtToken;
    }
    
    public static Jws<Claims> parseJwt(String jwtString) {
        Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), 
                                        SignatureAlgorithm.HS256.getJcaName());

        Jws<Claims> jwt = Jwts.parserBuilder()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(jwtString);

        return jwt;
    }
    
}
