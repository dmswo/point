package spring.point.point.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.point.global.exception.BusinessException;
import spring.point.point.dto.request.CreatePoint;
import spring.point.point.dto.response.UserPointResponse;
import spring.point.point.entity.PointBal;
import spring.point.point.repository.PointRepository;
import spring.point.point.service.PointService;

import static spring.point.global.constant.ExceptionCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    @Override
    public UserPointResponse getUserPoint(String userId) {
        PointBal point = pointRepository.findByUserId(userId).orElseThrow(() -> new BusinessException(USER_NOT_FOUND));
        return UserPointResponse.builder()
                .userId(point.getUserId())
                .pointBal(point.getPointBal())
                .build();
    }

    @Override
    public UserPointResponse createUserPoint(CreatePoint createPoint) {
        PointBal point = PointBal.of(createPoint);
        PointBal save = pointRepository.save(point);
        return UserPointResponse.builder()
                .userId(save.getUserId())
                .pointBal(save.getPointBal())
                .build();
    }
}
