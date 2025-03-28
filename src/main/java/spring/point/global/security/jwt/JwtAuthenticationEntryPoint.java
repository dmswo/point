package spring.point.global.security.jwt;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import spring.point.global.constant.ExceptionCode;

import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint extends AbstractAuthResponseWriter implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        writeAuthErrorResponse(response, ExceptionCode.UNAUTHORIZED);
    }
}
