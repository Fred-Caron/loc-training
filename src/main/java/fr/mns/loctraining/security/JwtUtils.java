package fr.mns.loctraining.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JwtUtils {

    private static final String SIGNATURE_KEY = "ThisIsMySignatureKey";

    //permet de générer le java web token
    public static String generateJwt(CustomUserDetails userDetails) {
        Map<String, Object> data = new HashMap<>();
        data.put("user", userDetails.getUser());

        //on utilise la librairie pour obtenir les infos suivantes
        return Jwts.builder()
                .setClaims(data)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(getExpirationDate())
                .signWith(SignatureAlgorithm.HS256, SIGNATURE_KEY)
                .compact();
    }

    private static Date getExpirationDate() {
        Date expirationDate = new Date();
        expirationDate.setTime(expirationDate.getTime() + 3600 * 1000);
        return expirationDate;
    }

    //parser : parser quelque chose = le lire // on a de la donnnée brut, qu'on va lire et qu'on va compacter en le parsant
    public static Claims getData(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNATURE_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public static boolean validate(String token) {
        try {
            Claims data = getData(token);
            boolean isTokenExpired = data.getExpiration().before(new Date());
            return !isTokenExpired;
        } catch (Exception e) {
            return false;
        }
    }
}
