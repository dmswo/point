package spring.point.global.security.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "authorization.work-point")
@Getter
@Setter
public class WorkApiKeyProperties {
    private String xApiKeyHeader;
    private String xApiKeyValue;
}
