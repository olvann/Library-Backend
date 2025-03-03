package com.ximple.library.exception;

import com.ximple.library.model.dto.ResponseDTO;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.ximple.library.utils.ResponseUtils.buildFailureResponse;

@Hidden
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity handleNotFoundException(NotFoundException exception) {
        logException(exception);
        return buildFailureResponse(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception exception) {
        logException(exception);
        return buildFailureResponse(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logException(Exception exception) {
        log.error("LibraryException: {} - Cause: {}",
                exception.getMessage(), exception.getCause() != null ? exception.getCause().getMessage() : "N/A");
    }
}
