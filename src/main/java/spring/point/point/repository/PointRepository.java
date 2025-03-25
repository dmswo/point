package spring.point.point.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.point.point.entity.PointBal;

import java.util.Optional;

public interface PointRepository extends JpaRepository<PointBal, Long> {
    Optional<PointBal> findByUserId(String userId);
}
