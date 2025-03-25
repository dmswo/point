package spring.point.global.security.jwt;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import spring.point.global.constant.ExceptionCode;

@Component
public class DefaultFilterResponseWriter extends AbstractAuthResponseWriter {

    public void writeAuthErrorResponse(HttpServletResponse response, ExceptionCode exceptionCode) {
        super.writeAuthErrorResponse(response, exceptionCode);
    }
}
