package spring.point.global.security.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    private final WorkApiKeyProperties workApiKeyProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String xApiKeyHeader = workApiKeyProperties.getXApiKeyHeader();
        String xApiKeyValue = workApiKeyProperties.getXApiKeyValue();
        if (request.getHeader(xApiKeyHeader).equals(xApiKeyValue)) {
            filterChain.doFilter(request, response);
        }
    }
}