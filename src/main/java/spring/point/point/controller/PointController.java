package spring.point.point.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring.point.global.dto.ApiResponse;
import spring.point.point.dto.request.CreatePoint;
import spring.point.point.dto.response.UserPointResponse;
import spring.point.point.service.PointService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/point")
@Tag(name="/point", description = "포인트 관련 API")
public class PointController {

    private final PointService pointService;

    @Operation(summary = "사용자 포인트 조회 API", description = "사용자 포인트 조회 API")
    @GetMapping("/user/{userId}")
    public ApiResponse<UserPointResponse> getUserPoint(@PathVariable("userId") String userId) {
        return ApiResponse.successResponse(pointService.getUserPoint(userId));
    }

    @Operation(summary = "사용자 포인트 생성 API", description = "사용자 포인트 생성 API")
    @PostMapping("/user")
    public ApiResponse<UserPointResponse> createUserPoint(@RequestBody CreatePoint createPoint) {
        return ApiResponse.successResponse(pointService.createUserPoint(createPoint));
    }
}
