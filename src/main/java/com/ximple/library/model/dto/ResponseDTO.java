package com.ximple.library.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ximple.library.enums.ResponseStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseDTO<T>(
        ResponseStatus responseStatus,
        String message,
        String exceptionCause,
        T content) {
}
