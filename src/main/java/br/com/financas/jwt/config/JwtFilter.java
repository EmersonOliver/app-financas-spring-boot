package br.com.financas.jwt.config;
/*
 * package br.com.financas.config;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.FilterChain; import javax.servlet.ServletException;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import io.jsonwebtoken.ExpiredJwtException;
 * 
 * @Component public class JwtFilter extends OncePerRequestFilter {
 * 
 * @Autowired private JWTUtil tokenUtil;
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException { final String reqHeader =
 * request.getHeader("Authorization"); String jwtToken = ""; String username =
 * ""; if (reqHeader != null && reqHeader.startsWith("Bearer ")) { jwtToken =
 * reqHeader.substring(7); try { username = tokenUtil.nomeUsuario(jwtToken); }
 * catch (IllegalArgumentException e) {
 * System.out.println("Unable to get JWT Token"); } catch (ExpiredJwtException
 * e) { System.out.println("JWT Token has expired"); } } else {
 * logger.warn("JWT Token does not begin with Bearer String"); } }
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */