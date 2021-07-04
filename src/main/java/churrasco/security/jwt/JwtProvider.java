package churrasco.security.jwt;

import churrasco.security.entities.MainUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
        
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwtSecret}")
    private String secret;
    
    @Value("${jwtExpirationMs}")
    private int expiration;
    
    public String generateToken(Authentication authentication){
        MainUser mainUser = (MainUser) authentication.getPrincipal();    
        
        return Jwts.builder()
                .setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
    
    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token malformed");
        } catch (UnsupportedOperationException e) {
            logger.error("token unsupported");
        } catch (ExpiredJwtException e) {
            logger.error("token expired");
        } catch (IllegalArgumentException e) {
            logger.error("token empty");
        } catch (SignatureException e) {
            logger.error("fail in signature");
        }
        
        return false;
    }
    
}
