package spring.point.point.service;

import spring.point.point.dto.request.CreatePoint;
import spring.point.point.dto.response.UserPointResponse;

public interface PointService {
    UserPointResponse getUserPoint(String userId);
    UserPointResponse createUserPoint(CreatePoint createPoint);
}
