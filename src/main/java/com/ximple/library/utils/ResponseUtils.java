package com.ximple.library.utils;

import com.ximple.library.enums.ResponseStatus;
import com.ximple.library.model.dto.ResponseDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseUtils {
    public static ResponseEntity<ResponseDTO> buildFailureResponse(Exception exception, HttpStatus status) {
        ResponseDTO<Void> response = new ResponseDTO<>(
                ResponseStatus.FAILURE,
                exception.getMessage(),
                Optional.ofNullable(exception.getCause()).map(Throwable::toString).orElse(null),
                null
        );
        return new ResponseEntity<>(response, status);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> buildOkResponse(String message, T content) {
        ResponseDTO<T> response = new ResponseDTO<>(
                ResponseStatus.SUCCESS,
                message,
                null,
                content
        );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ResponseDTO<T>> buildCreatedResponse(String message, T content) {
        ResponseDTO<T> response = new ResponseDTO<>(
                ResponseStatus.SUCCESS,
                message,
                null,
                content
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
