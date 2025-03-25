package spring.point.global.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        // 요청의 헤더에서 사용자 ID를 가져옴 (예: X-User-Id)
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String userId = request.getHeader("X-USER-ID"); // API 요청 헤더에서 가져오기
            if (userId != null && !userId.isEmpty()) {
                return Optional.of(userId);
            }
        }
        return Optional.of("SYSTEM"); // 기본값 (예: 시스템 처리)
    }
}
