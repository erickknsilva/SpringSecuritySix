package securitySix.service.implement.authJwtFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import securitySix.service.TokenService;

import java.security.Key;
import java.util.Date;

import static io.jsonwebtoken.Jwts.SIG.HS256;

@Service
public class TokenServiceImpl implements TokenService {


    private Key key = Keys.hmacShaKeyFor(HS256.key().build().getEncoded());

    @Override
    public String generatedToken(Long userId) {

        Date today = new Date();
        Date expiration = new Date(today.getTime() + 3600000);
        return Jwts.builder()
                .issuer("Spring Security")
                .subject(userId.toString())
                .issuedAt(today)
                .expiration(expiration)
                .signWith(key)
                .compact();
    }

    @Override
    public Boolean isValid(String token) {
        try {
            getClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Long getUserId(String token) {
        var claimsUser = getClaimsJws(token);
        return Long.parseLong(claimsUser.getPayload().getSubject());
    }

    public Jws<Claims> getClaimsJws(String token) {

        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseSignedClaims(token);

        return claimsJws;
    }

}
