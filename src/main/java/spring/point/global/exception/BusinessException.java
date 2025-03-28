package spring.point.global.exception;

import lombok.Getter;
import spring.point.global.constant.ExceptionCode;

@Getter
public class BusinessException extends RuntimeException{
    private final ExceptionCode exceptionCode;

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
