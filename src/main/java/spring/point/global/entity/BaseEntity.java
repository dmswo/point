package spring.point.global.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {
    @CreatedBy
    @Column(updatable = false)
    private String regId;

    @CreatedDate
    private LocalDateTime regDt;

    @LastModifiedBy
    private String modId;

    @LastModifiedDate
    private LocalDateTime modDt;
}
