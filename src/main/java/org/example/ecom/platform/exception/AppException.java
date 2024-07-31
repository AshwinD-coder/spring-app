package org.example.ecom.platform.exception;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class AppException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private AppExceptionType appExceptionType;

    public AppException(AppExceptionType appExceptionType) {
        super(appExceptionType.getMessage());
    }

    public AppException(String message) {
        super(message);
    }

}
