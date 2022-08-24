package br.com.financas.jwt.config;
/*
 * package br.com.financas.config;
 * 
 * import java.util.Date; import java.util.function.Function;
 * 
 * import org.springframework.beans.factory.annotation.Value; import
 * org.springframework.stereotype.Component;
 * 
 * import io.jsonwebtoken.Claims; import io.jsonwebtoken.Jwts;
 * 
 * @Component public class JWTUtil {
 * 
 * @Value("${jwt.secret}") private String secret;
 * 
 * public String nomeUsuario(String token) { return getClaimFromToken(token,
 * Claims::getSubject); }
 * 
 * public <T> T getClaimFromToken(String token, Function<Claims, T>
 * claimsResolver) { final Claims claims = getAllClaimsFromToken(token); return
 * claimsResolver.apply(claims); }
 * 
 * private Claims getAllClaimsFromToken(String token) { return
 * Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); }
 * 
 * public Boolean validateToken(String token) { final String username =
 * nomeUsuario(token); return (username.equals(username) &&
 * !isTokenExpired(token)); }
 * 
 * private Boolean isTokenExpired(String token) { final Date expiration =
 * getExpirationDateFromToken(token); return expiration.before(new Date()); }
 * 
 * public Date getExpirationDateFromToken(String token) { return
 * getClaimFromToken(token, Claims::getExpiration); } }
 */