package org.example.ecom.platform.exception;

import org.example.ecom.platform.restutils.RestResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.logging.Logger;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger logger = Logger.getLogger(ExceptionHandler.class.getName());

    /**
     * @param ex Exception to be handled
     * @return ResponseEntity object when exception is handled
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(
            Exception ex) {
        logger.info("Exception Occurred : " + ex.getMessage());
        return ResponseEntity.badRequest().body(RestResponse.error(ex.getMessage()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(ExceptionHandler::getDefaultMessage)
                .toList();
        return ResponseEntity.badRequest().body(RestResponse.error("Invalid request payload", errors));
    }

    private static String getDefaultMessage(FieldError fieldError) {
        return fieldError.getDefaultMessage();
    }
}
