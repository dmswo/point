package spring.point.point.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import spring.point.global.entity.BaseEntity;
import spring.point.point.dto.request.CreatePoint;

@Entity
@Table(name = "pointBal")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class PointBal extends BaseEntity {

    private static final long DEFAULT_POINT_BALANCE = 10000L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POINT_ID")
    private Long id;

    @Column(nullable = false, length = 50)
    private String userId;

    @Column(nullable = false)
    private Long pointBal;

    public static PointBal of(CreatePoint createPoint) {
        return new PointBal(createPoint.getUserId(), DEFAULT_POINT_BALANCE);
    }

    protected PointBal(String userId, Long pointBal) {
        this.userId = userId;
        this.pointBal = pointBal;
    }
}